package com.winefine.store.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winefine.store.model.service.ProductService;
import com.winefine.store.model.vo.Product;

/**
 * Servlet implementation class SearchProductController
 */
@WebServlet("/search.pr")
public class SearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchWord = "";
		
		if(request.getParameter("searchWord") != null) {
			searchWord = request.getParameter("searchWord");
			
			ArrayList<Product> list = new ProductService().selectProduct(searchWord);
			
			request.setAttribute("list",list);

			if(!list.isEmpty()) {
				
				request.getRequestDispatcher("views/store/storeThumbnailListforSearch.jsp").forward(request,response);
			}
			else {
				// 에러페이지 바꿔주기
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				//request.getRequestDispatcher("views/store/storeThumbnailListforSearch.jsp").forward(request,response);
			}
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
