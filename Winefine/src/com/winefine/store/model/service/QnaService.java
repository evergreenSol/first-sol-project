/* < Service 단 > 
 * 메소드 안에 기본 5단계 
 * 1) conn 생성
 * 2) 변수에 값담기 = Dao단 메소드 호출 
 * 3) commit,rollback 또는 생략
 * 4) 자원반납
 * 5) 결과 반환*/

package com.winefine.store.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.winefine.common.JDBCTemplate.*;
import com.winefine.common.model.vo.PageNation;
import com.winefine.store.model.dao.QnaDao;
import com.winefine.store.model.dao.ReviewDao;
import com.winefine.store.model.vo.Attachment;
import com.winefine.store.model.vo.Qna;


public class QnaService {

	// 1. listCount 를 조회하는 메소드
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new QnaDao().selectListCount(conn);

		close(conn);
		
		return listCount;
		
	}
	
	// 2. QnaList를 조회할 메소드 
	public ArrayList<Qna> selectList(PageNation pn, int productNo){
		Connection conn = getConnection();
		
		ArrayList<Qna> qnaList = new QnaDao().selectList(conn, pn, productNo);
		
		close(conn);
		
		return qnaList;
		
	}

	// 3. Qna를 추가하는 메소드
	public int insertQna(Qna q) {
		Connection conn = getConnection();
		
		int result = new QnaDao().insertQna(conn, q);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
  // 답변추가 메소드(0529 수빈추가)
   public int qnaInsertAnswer(String qno, String answer) {
      Connection conn = getConnection();
      
      int result = new QnaDao().qnaInsertAnswer(conn, qno, answer);
      
      if(result > 0) {
         commit(conn);
      }
      else {
         rollback(conn);
      }
      
      close(conn);
      
      return result;
   }
   
   public ArrayList<Qna> selectQnaList(int userNo) {
	   
	   Connection conn = getConnection();
		
		ArrayList<Qna> qnaList = new QnaDao().selectQnaList(conn, userNo);
		
		close(conn);
		
		return qnaList;
   }


}
