package com.winefine.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winefine.order.model.service.OrderService;
import com.winefine.order.model.vo.Order;
import com.winefine.order.model.vo.OrderProduct;

/**
 * Servlet implementation class MyPageOrderDetailView
 */
@WebServlet("/orderDetail.me")
public class MyPageOrderDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageOrderDetailView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));

		
		ArrayList<OrderProduct> opList = new OrderService().selectOrderProduct(orderNo);
		Order o = new OrderService().selectOrderByOrderNo(orderNo);
		

		
		if(!opList.isEmpty()) {
			request.setAttribute("o", o);
			request.setAttribute("opList", opList);
			request.getRequestDispatcher("views/member/myPage_viewOrderDetail.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "주문 상세 조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
