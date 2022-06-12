package com.winefine.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winefine.member.model.vo.Member;
import com.winefine.order.model.service.OrderService;
import com.winefine.order.model.vo.Order;
import com.winefine.order.model.vo.OrderProduct;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/myPage.me")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 주문내역 리스트를 가져온다.
		
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();


		ArrayList<Order> orderAll = new ArrayList<>();
		ArrayList<OrderProduct> opList = new ArrayList<>();
		
		orderAll = new OrderService().selectOrderList(userNo);
		

		
		if(!orderAll.isEmpty()) {
			for(Order o : orderAll) {
				
				opList = new OrderService().selectOrderProduct(o.getOrderNo());
			}
			
		}
		

//		request.setAttribute("paidOrder", paidOrder);
		request.setAttribute("orderAll", orderAll);
		request.setAttribute("opList", opList);
	 

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
