package com.winefine.oneqna.model.service;

import static com.winefine.common.JDBCTemplate.close;
import static com.winefine.common.JDBCTemplate.commit;
import static com.winefine.common.JDBCTemplate.getConnection;
import static com.winefine.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.winefine.oneqna.model.dao.OneqnaDao;
import com.winefine.oneqna.model.vo.Category;
import com.winefine.oneqna.model.vo.Oneqna;

public class OneqnaService {

	
	public ArrayList<Oneqna> selectOneqnaList() {
		
		Connection conn = getConnection();
		
		ArrayList<Oneqna> list = new OneqnaDao().selectOneqnaList(conn);
		
		close(conn);
		
		return list;
	}
	
	public int insertOneqna(Oneqna o) {
		
		Connection conn = getConnection();
		
		int result = new OneqnaDao().insertOneqna(conn, o);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public Oneqna selectOneqna(int oneqnaNo) {
		
		Connection conn = getConnection();
		
		Oneqna o = new OneqnaDao().selectOneqna(conn, oneqnaNo);
		
		close(conn);
		
		return o;
	}
	
	public ArrayList<Category> selectCategoryList() {
		
		Connection conn = getConnection();
		
		ArrayList<Category> list = new OneqnaDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
	}
	
	public int updateOneqna(int oneqnaNo, String answer) {
	
		Connection conn = getConnection();
		
		int result = new OneqnaDao().updateOneqna(conn, oneqnaNo, answer);
		
		if(result > 0) {
			
			commit(conn);
		}
		else {
			
			rollback(conn);
		}
		close(conn);
		
		return result;
				
	}
	public int deleteOneqna(int oneqnaNo) {
		
		Connection conn = getConnection();
		
		int result = new OneqnaDao().deleteOneqna(conn, oneqnaNo);
		
		if(result > 0) {
			
			commit(conn);
		}
		else {
			
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}
	
	public ArrayList<Oneqna> selectOneqnaList(int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Oneqna> list = new OneqnaDao().selectOneqnaList(conn, userNo);
		
		close(conn);
		
		return list;
	}
}
