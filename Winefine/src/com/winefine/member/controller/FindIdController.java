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
 * Servlet implementation class FindIdController
 */
@WebServlet("/findId.me")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 인코딩 설정(post 방식)
		request.setCharacterEncoding("UTF-8");
		
		// 2. 필요한 변수 뽑기
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		
		// 3. MemberService 의 메소드를 호출 및 결과값 받기: 아이디, 회원번호
		Member m = new MemberService().selectMemberId(userName, phone);

		
		HttpSession session = request.getSession();	
		
		// 4. 반환 결과에 따라 응답 페이지 지정
		if(m == null) { // 정보가 없을 경우
			
			session.setAttribute("alertMsg", "일치하는 회원 아이디가 없습니다.");
			
			request.getRequestDispatcher("views/member/findId.jsp").forward(request, response);
		
		}
		else { //정보가 있을 경우
			
			
			request.setAttribute("loginUser", m);
			
			request.getRequestDispatcher("views/member/findIdFin.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/findIdFin.me");
		
		
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
