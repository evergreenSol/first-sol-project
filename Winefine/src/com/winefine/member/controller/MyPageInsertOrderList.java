package com.winefine.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winefine.cart.model.service.CartService;
import com.winefine.cart.model.vo.Cart;
import com.winefine.member.model.vo.Member;
import com.winefine.order.model.service.OrderService;
import com.winefine.order.model.vo.Order;
import com.winefine.order.model.vo.OrderProduct;
import com.winefine.store.model.service.ProductService;


/**
 * Servlet implementation class MyPageInsertOrderList
 */
@WebServlet("/insertOrder.me")
public class MyPageInsertOrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageInsertOrderList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		//int totalPrice = Integer.parseInt(request.getParameter("totalPrice")); // 총결제금액
		
		String pickup = request.getParameter("pickup");
		int totalPrice = 0;
		String pickupDate = request.getParameter("pickupDate"); // 픽업 예정일
		String locationCode = request.getParameter("locationCode");
		String paymentCode = request.getParameter("paymentCode"); // 1(카카오페이) OR 2(현장결제)
		String orderStatus = "";
		if(paymentCode.equals("1")) {
			orderStatus = "결제완료";
		}
		else {
			orderStatus = "결제대기";
		}
		
		ArrayList<Cart> list = new CartService().selectCartList(userNo);

		
		
		if(!list.isEmpty()) {
			for(Cart c : list) {
				totalPrice += c.getBottle() * c.getPrice();

			}
		}
		
		Order o = new Order();
		o.setOrderUser(String.valueOf(userNo));
		o.setPickup(pickup);
		o.setPickupDate(pickupDate);
		o.setTotalPrice(totalPrice);
		o.setLocationCode(locationCode);
		o.setPaymentCode(paymentCode);
		o.setOrderStatus(orderStatus);
		
		
		Order paidOrder = null;
		
		// 주문상세정보는 여러개가 나올 수 있다.(1주문에 여러 상품 가능하므로)

		ArrayList<OrderProduct> opList = new ArrayList<>();
		
		int result = new OrderService().insertOrder(o);
		
		int resultOrderProduct = 0;
		
		if(result > 0) { // 주문 테이블에 주문생성을 성공한 것.
			// 이제 주문상세 테이블 만들기 그러기 위해서 주문 테이블 먼저 가져와야한다.
			
			paidOrder = new OrderService().selectOrder(userNo);
			
			int orderNo = paidOrder.getOrderNo();

			if(!list.isEmpty()) {
				for(Cart c : list) {
				    String productNo = c.getProductNo(); // 카트테이블 변경했음: 한일이꺼도 변경하기.
				    int price = c.getPrice();
				    int bottle = c.getBottle();
				    
							
				    resultOrderProduct = new OrderService().insertOrderProduct(orderNo, productNo, price, bottle);

				    // 주문 상세 하나가 만들어짐 - 카트 수만큼 돌아야한다.
				    // 만들어졌으면 추가하기.
				    if(resultOrderProduct > 0) { // 성공했음. 이건 이제 한 줄 되었음.
				    	// 하나 조회하고?
				    	opList = new OrderService().selectOrderProduct(orderNo);
				    	// 하나 넣고?
				    	// opList.add(op);
				    	
				    	// 이제 성공했으면, 장바구니 지우고
				    	// 주문이랑 셀렉트 전달
				    	
				    }
				    else {
				    	request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				    	
				    }
				    
				}
			}
			

			
			// 주문상세 테이블을 만들 수 있다.


		}
		else { // 주문이 안만들어짐
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		
		int deleteCartResult = 0;
		int rsc = 0; // revisionStockCount
		
		if(!opList.isEmpty()) {
			
			for(OrderProduct op : opList) {
				
				int productNo = op.getProductNo();
				int count = op.getpCount();
				
				rsc = new ProductService().revisionStockCount(productNo, count);
				
				if(rsc > 0) {
				}
				else {
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}
			}
			
			deleteCartResult = new CartService().paidAfterDeleteCart(userNo); // 카트 삭제
		}
		
		if(deleteCartResult > 0) {
			// 카트 삭제 성공 -> 끝
			
		}
		else {
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		ArrayList<Order> orderAll = new ArrayList<>(); 
		
		orderAll = new OrderService().selectOrderList(userNo);
		
//		request.setAttribute("paidOrder", paidOrder);
		request.setAttribute("orderAll", orderAll);
		request.setAttribute("opList", opList);
		
		if(orderStatus.equals("결제완료")) {
			
			request.getSession().setAttribute("alertMsg", "주문 및 결제에 성공했습니다! 마이페이지 > 주문내역에서 확인 가능합니다.");
		}
		else {
			request.getSession().setAttribute("alertMsg", "주문에 성공했습니다! 마이페이지 > 주문내역에서 확인 가능합니다.");
		}
		
//		response.sendRedirect("/myPage.me");
		request.getRequestDispatcher("views/member/myPage_viewOrderList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
