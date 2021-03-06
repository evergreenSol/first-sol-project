/* 폼 전송 방식 일반방식X multipart/form-data로 전송했으니 
 * => multipart 라는 객체에 값을 이관시켜서 뽑아야 한다.(안그러면 다 null로 뽑힘)
 * 
 * 1. 인코딩설정(Post방식)
 * 2. 요청시 전달값 뽑고 VO객체 가공
 *   특별히 mulripart/form-data의 경우는
 *   1) 전송되는 파일을 처리할 작업내용지정 : 파일용량제한, 파일저장할 서버컴의 폴더 경로지정
 *   	ㄱ. 파일용량제한
 *   	ㄴ. 서버컴 폴더 경로 지정 : 세션객체에서 제공하는 getServletContext() 메소드 + application 내장객체에서 제공하는 getRealPath()메소드 활용
 *   2) 전달된 파일명 수정 및 서버에 업로드 
 *   3) DB에 기록할 데이터 뽑아서 VO 객체로 가공 
 * 3. 변수에 값담기 = Service로 요청한 결과 
 * 4. 결과에 따른 응답화면 지정
 */	

package com.winefine.store.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.winefine.common.MyFileRenamePolicy;
import com.winefine.store.model.service.QnaService;
import com.winefine.store.model.vo.Attachment;
import com.winefine.store.model.vo.Qna;

/**
 * Servlet implementation class QnaInsertController
 */
@WebServlet("/insert.qn")
public class QnaInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 전송될 파일 용량 제한 (10mbyte == 10 * 1024 * 1024byte)
		int maxSize = 10 * 1024 * 1024;
		
		// 서버컴의 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/product_upfiles/");
		
		// 파일명 수정 및 서버 업로드 & 단, 외부라이브러리(cos.jar) 끌어다 써야 함 
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());

		// 요청시 전달값 : userNo, title, content, upfile 뽑아서 VO객체로 가공(Qna, Attachment)
		int productNo = Integer.parseInt(multiRequest.getParameter("pno"));
		String qnaWriter = multiRequest.getParameter("userNo");
		String qnaTitle = multiRequest.getParameter("qnaTitle");
		String qnaContent = multiRequest.getParameter("qnaContent");
		String qnaPhoto = multiRequest.getFilesystemName("qnaPhoto");
		

		Qna q = new Qna();
		
		if(qnaPhoto!=null) {
			
			qnaPhoto = request.getContextPath() + "/resources/product_upfiles/" + multiRequest.getFilesystemName("qnaPhoto");
		
			q.setProductNo(productNo);
			q.setQnaWriter(qnaWriter);
			q.setQnaTitle(qnaTitle);
			q.setQnaContent(qnaContent);
			q.setQnaPhoto(qnaPhoto);
		}
		
		else {
			
			q.setProductNo(productNo);
			q.setQnaWriter(qnaWriter);
			q.setQnaTitle(qnaTitle);
			q.setQnaContent(qnaContent);
		}
		
		
		// 변수에 값담기 = Service로 요청 후 결과 받기
		int result = new QnaService().insertQna(q);
		
		// 결과에 따른 응답화면 지정 
		if(result > 0) { // 성공
			request.getSession().setAttribute("alertMsg", "게시글 작성 완료");
			//request.getRequestDispatcher("views/store/qnaListView.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/qna?pno=" + productNo + "&currentPage=1" );
		}
		else { // 실패 => 에러페이지 포워딩
			
			
			request.setAttribute("errorMsg", "게시글 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
