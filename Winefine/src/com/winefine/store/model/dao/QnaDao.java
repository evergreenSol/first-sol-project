/* < Dao 단 > 
 * 0) 어떤 쿼리문을 실행해서 어떤 값을 받는지 먼저 생각
 * 1) 필요한 변수 셋팅
 * 2) pstmt 객체생성(sql문보내주기) & try-catch
 * 3) 쿼리문이 미완성인 경우 채워주기
 * 4,5) 변수에값담기 = 쿼리문실행
 * 6) ResultSet으로부터 값 뽑아내서 객체로 가공
 * 7) 자원반납
 * 8) 결과반환
 */

package com.winefine.store.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import com.winefine.common.model.vo.PageNation;
import com.winefine.store.model.vo.Attachment;
import com.winefine.store.model.vo.Qna;
import static com.winefine.common.JDBCTemplate.*;

public class QnaDao {

	// 공통적인 코드를 빼둘 곳
	private Properties prop = new Properties();
	
	public QnaDao() {
		try {
			prop.loadFromXML(new FileInputStream(QnaDao.class.getResource("/sql/store/qna-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 1. listCount 를 조회하는 메소드
	public int selectListCount(Connection conn) {
		
		// SELECT문 => ResultSet 객체 (한개의 행 조회 예정)
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
			
		}
		return listCount;
		
	}

	// 2. QnaList를 조회할 메소드 
	public ArrayList<Qna> selectList(Connection conn, PageNation pn, int productNo){

		// SELECT문 => ResultSet 객체 (한개의 행 조회 예정)
		ArrayList<Qna> qnaList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pn.getCurrentPage()-1) * pn.getBoardLimit() + 1;
			int endRow = startRow + pn.getBoardLimit() - 1;
			
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				qnaList.add(new Qna(rset.getInt("QNA_NO"),
								 rset.getString("QNA_OPEN"),
								 rset.getString("QNA_TITLE"),
								 rset.getDate("CREATE_DATE"),
								 rset.getString("USER_ID"),
								 rset.getInt("COUNT"),
								 rset.getString("QNA_CONTENT"),
								 rset.getString("QNA_PHOTO"),
								 rset.getString("ANSWER"),
								 rset.getDate("ANSWER_DATE"),
								 rset.getString("ANSWER_YN")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		return qnaList;
		
	}

	// 3. Qna를 추가하는 메소드
	public int insertQna(Connection conn, Qna q) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
			try {
					if(q.getQnaPhoto() != "" ) {
						pstmt = conn.prepareStatement(prop.getProperty("insertQnaPhoto"));
						
						pstmt.setInt(1, q.getProductNo());
						pstmt.setString(2, q.getQnaWriter());
						pstmt.setString(3, q.getQnaTitle());
						pstmt.setString(4, q.getQnaContent());
						pstmt.setString(5, q.getQnaPhoto());
						
						result = pstmt.executeUpdate();
					}
					
					else {
						pstmt = conn.prepareStatement(prop.getProperty("insertQnaPhotoX"));
						
						pstmt.setInt(1, q.getProductNo());
						pstmt.setString(2, q.getQnaWriter());
						pstmt.setString(3, q.getQnaTitle());
						pstmt.setString(4, q.getQnaContent());
						
						result = pstmt.executeUpdate();
					}
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
		return result;
	}
	
   // 답변추가 메소드(0529 수빈추가)
   public int qnaInsertAnswer(Connection conn, String qno, String answer) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("qnaInsertAnswer");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, answer);
         pstmt.setString(2, qno);
         
         result = pstmt.executeUpdate();
         
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }

      return result;
   }

   
   public ArrayList<Qna> selectQnaList(Connection conn, int userNo) {
	   
		ArrayList<Qna> qnaList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQnaList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				qnaList.add(new Qna(rset.getInt("QNA_NO"),
								 rset.getInt("PRODUCT_NO"),
								 rset.getString("QNA_OPEN"),
								 rset.getString("QNA_TITLE"),
								 rset.getDate("CREATE_DATE"),
								 rset.getString("USER_ID"),
								 rset.getInt("COUNT"),
								 rset.getString("QNA_CONTENT"),
								 rset.getString("QNA_PHOTO"),
								 rset.getString("ANSWER"),
								 rset.getDate("ANSWER_DATE"),
								 rset.getString("ANSWER_YN")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		return qnaList;
	   
   }
	
	
}

	
