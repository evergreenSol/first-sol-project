package com.winefine.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winefine.oneqna.model.service.OneqnaService;
import com.winefine.oneqna.model.vo.Oneqna;

/**
 * Servlet implementation class OneqnaAdminDetailController
 */
@WebServlet("/Mdetail.on")
public class OneqnaAdminDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneqnaAdminDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get 방식
		
		int oneqnaNo = Integer.parseInt(request.getParameter("ono"));
		
		Oneqna o = new OneqnaService().selectOneqna(oneqnaNo);
		
		if(o != null) {
			
			request.setAttribute("o", o);
			
			request.getRequestDispatcher("views/admin/oneqnaDetailView.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errorMsg", "1:1문의 조회 실패");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
