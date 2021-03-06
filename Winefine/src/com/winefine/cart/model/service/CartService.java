package com.winefine.cart.model.service;

import static com.winefine.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.winefine.cart.model.dao.CartDao;
import com.winefine.cart.model.vo.Cart;

public class CartService {

	public int insertCart(Cart c) {
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) DAO 로 Connection 과 전달값 넘기고 결과 받기
		int result = new CartDao().insertCart(conn, c);

		// 3) 결과에 따라 commit, rollback 처리
		if(result > 0) { // 성공
			
			commit(conn);
		}
		else { // 실패
			
			rollback(conn);
		}
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) 결과 반환
		return result;
	}

	public ArrayList<Cart> selectCartList(int userNo) {

		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 객체와 전달값을 DAO 로 넘기기 및 결과 받기
		ArrayList<Cart> list = new CartDao().selectCartList(conn, userNo);
		
		// 3) commit, rollback 처리 (select 문이라 생략)
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) 결과 반환
		return list;
	}

	public int deleteCart(int cartNo) {

		Connection conn = getConnection();
		
		int result = new CartDao().deleteCart(conn, cartNo);
		
		if(result > 0) {
			
			commit(conn);
		}
		else {
			
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int paidAfterDeleteCart(int userNo) {
		
		Connection conn = getConnection();
		
		int result = new CartDao().paidAfterDeleteCart(conn, userNo);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		return result;
		
		
		
	}

}
