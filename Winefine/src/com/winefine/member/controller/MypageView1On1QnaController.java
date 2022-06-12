package com.winefine.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winefine.oneqna.model.service.OneqnaService;
import com.winefine.oneqna.model.vo.Oneqna;

/**
 * Servlet implementation class MypageView1On1QnaController
 */
@WebServlet("/view1On1.me")
public class MypageView1On1QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageView1On1QnaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int oneqnaNo = Integer.parseInt(request.getParameter("ono"));
		
		Oneqna o = new OneqnaService().selectOneqna(oneqnaNo);
		
		request.setAttribute("o", o);
		request.getRequestDispatcher("views/member/myPage_view1on1QnaDetail.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
