package com.winefine.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.winefine.member.model.service.MemberService;
import com.winefine.member.model.vo.Member;

/**
 * Servlet implementation class MyPageMemberDeleteController
 */
@WebServlet("/deleteMem.me")
public class MyPageMemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageMemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		int result = new MemberService().deleteMember(userNo);
		
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원 탈퇴가 되었습니다.");
			session.removeAttribute("loginUser");
			response.sendRedirect(request.getContextPath() + "/main.do");
		}
		else {
			request.setAttribute("errorMsg", "회원 탈퇴에 실패했습니다.");
			request.getRequestDispatcher("views/commons/errorPage.jsp").forward(request, response);
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
