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
import com.winefine.order.model.vo.Order;
import com.winefine.store.model.dao.ReviewDao;
import com.winefine.store.model.vo.Review;

public class ReviewService {

	// 1. listCount 를 조회하는 메소드
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new ReviewDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}


	// 2. ReviewList를 조회할 메소드
	public ArrayList<Review> selectList(PageNation pn, int productNo) {
		Connection conn = getConnection();
		
		ArrayList<Review> reviewList = new ReviewDao().selectList(conn, pn, productNo);
		
		close(conn);
		
		return reviewList;
	}


	// 3. ReviewListAll(관리자용 : 모든정보가져오기)를 조회할 메소드
	public ArrayList<Review> selectListAll(PageNation pn) {
		Connection conn = getConnection();
		
		ArrayList<Review> reviewList = new ReviewDao().selectListAll(conn, pn);
		
		close(conn);
		
		return reviewList;
	}

	// 4. ReviewUpdateStatus(관리자용 : 공개여부, 답변상태)를 수정할 메소드
	public int updateStatus(String status, String answer, int rNo) {
			Connection conn = getConnection();
			
			int result = new ReviewDao().updateStatus(conn, status, answer, rNo);
			
			if(result > 0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
	}

	// selectOrderForReview 메소드
	public Order selectOrderForReview(String reviewWriter, String productNo) {
		
		Connection conn = getConnection();
		
		Order o = new ReviewDao().selectOrderForReview(conn, reviewWriter, productNo);
		
		close(conn);
		
		return o;
	}
	
	// review 추가 메소드 
	public int insertReview(Review r, Order o) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().insertReview(conn, r, o);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	// 기간별 reviewList 조회 메소드 
	public ArrayList<Review> reviewListDate(String startDate, String endDate, PageNation pn) {

		Connection conn = getConnection();
		
		ArrayList<Review> reviewListDate = new ReviewDao().reviewListDate(conn, startDate, endDate, pn);
		
		close(conn);
		
		return reviewListDate;
	}
	
	public ArrayList<Review> selectReviewList(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Review> reviewListDate = new ReviewDao().selectReviewList(conn, userNo);
		
		close(conn);
		
		return reviewListDate;
	}



	
	
}
