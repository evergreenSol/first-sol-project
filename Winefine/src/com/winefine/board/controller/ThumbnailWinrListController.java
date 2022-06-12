package com.winefine.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winefine.board.model.service.BoardService;
import com.winefine.board.model.vo.Board;
// 와인용어 사용자 화면
/**
 * Servlet implementation class ThumbnailWinrListController
 */
@WebServlet("/list.th") 
public class ThumbnailWinrListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailWinrListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String boardType = request.getParameter("boardType");
		// 사진게시판 리스트페이지에 필요한 데이터들을 우선적으로 조회
		ArrayList<Board> list = new BoardService().selectThumbnailList(boardType);
		
		// 수화물 보내기
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/board/wineList.jsp").forward(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
