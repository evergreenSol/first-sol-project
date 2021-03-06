	package com.winefine.store.model.dao;
	
	import static com.winefine.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.winefine.common.model.vo.PageInfo;
import com.winefine.common.model.vo.PageNation;
import com.winefine.store.model.vo.Product;
	
	public class ProductDao {
	
		private Properties prop = new Properties();
		
		public ProductDao() {
			
			try {
				prop.loadFromXML(new FileInputStream(ProductDao.class.getResource("/sql/store/store-mapper.xml").getPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		public ArrayList<Product> selectProduct(Connection conn) {
			
			ArrayList<Product> list = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectProduct");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Product p = new Product(rset.getInt("PRODUCT_NO"),
											rset.getString("PRODUCT_TYPE"),
											rset.getString("PRODUCT_NAME"),
											rset.getInt("PRICE"),
											rset.getString("BRAND"),
											rset.getFloat("ALCOHOL"),
											rset.getInt("STOCK"),
											rset.getString("ORIGIN"),
											rset.getInt("SWEETNESS"),
											rset.getInt("ACIDITY"),
											rset.getInt("BODY"),
											rset.getInt("TANNIN"),
											rset.getString("STATUS"),
											rset.getInt("COUNT"),
											rset.getString("THUMBNAIL"),
											rset.getString("CONTENT_PHOTO1"),
											rset.getString("CONTENT_PHOTO2"),
											rset.getString("CONTENT"));
	
					list.add(p);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;	
		}
	
		
		public int insertProduct(Connection conn, Product p) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertProduct");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, p.getProductType());
				pstmt.setString(2, p.getProductName());
				pstmt.setInt(3, p.getPrice());
				pstmt.setString(4, p.getBrand());
				pstmt.setFloat(5, p.getAlcohol());
				pstmt.setInt(6, p.getStock());
				pstmt.setString(7, p.getOrigin());
				pstmt.setInt(8, p.getSweetness());
				pstmt.setInt(9, p.getAcidity());
				pstmt.setInt(10, p.getBody());
				pstmt.setInt(11, p.getTannin());
				pstmt.setString(12, p.getStatus());
				pstmt.setString(13, p.getThumbnail());
				pstmt.setString(14, p.getContentPhoto1());
				pstmt.setString(15, p.getContentPhoto2());
				pstmt.setString(16, p.getContent());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
		
		public Product selectOneProduct(Connection conn, int productNo) {
			
			Product p = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectOneProduct");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, productNo);
				
				rset = pstmt.executeQuery();
			
				if(rset.next()) {
					p = new Product(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_TYPE"),
									rset.getString("PRODUCT_NAME"),
									rset.getInt("PRICE"),
									rset.getString("BRAND"),
									rset.getFloat("ALCOHOL"),
									rset.getInt("STOCK"),
									rset.getString("ORIGIN"),
									rset.getInt("SWEETNESS"),
									rset.getInt("ACIDITY"),
									rset.getInt("BODY"),
									rset.getInt("TANNIN"),
									rset.getString("STATUS"),
									rset.getInt("COUNT"),
									rset.getString("THUMBNAIL"),
									rset.getString("CONTENT_PHOTO1"),
									rset.getString("CONTENT_PHOTO2"),
									rset.getString("CONTENT"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return p;
	
		}
		
	/*
	 	public int updateProduct(Connection conn, Product p) {
	 
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("updateProduct");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, p.getProductType());
				pstmt.setString(2, p.getProductName());
				pstmt.setInt(3, p.getPrice());
				pstmt.setString(4, p.getBrand());
				pstmt.setFloat(5, p.getAlcohol());
				pstmt.setInt(6, p.getStock());
				pstmt.setString(7, p.getOrigin());
				pstmt.setInt(8, p.getSweetness());
				pstmt.setInt(9, p.getAcidity());
				pstmt.setInt(10, p.getBody());
				pstmt.setInt(11, p.getTannin());
				pstmt.setString(12, p.getStatus());
				pstmt.setString(13, p.getThumbnail());
				pstmt.setString(14, p.getContentPhoto1());
				pstmt.setString(15, p.getContentPhoto2());
				pstmt.setString(16, p.getContent());
				pstmt.setInt(17, p.getProductNo());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
		*/

		public int updateProduct(Connection conn, Product p) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
	//		String sql = prop.getProperty("updateProduct");
			
			try {
				
				// ?????? ????????? ?????? ????????? ??? -> updateProduct 1~8
				// 1. 123 ??? ???
				// 2. 1??? ??? 
				// 3. 2??? ???
				// 4. 3??? ???
				// 5. 1, 2??? ???
				// 6. 2, 3??? ???
				// 7. 1, 3??? ???
				// 8. ??? ???
	
				if(p.getThumbnail() != null && p.getContentPhoto1() != null && p.getContentPhoto2() != null) {
					pstmt = conn.prepareStatement(prop.getProperty("updateProduct1"));
					
					pstmt.setString(1, p.getProductType());
					pstmt.setString(2, p.getProductName());
					pstmt.setInt(3, p.getPrice());
					pstmt.setString(4, p.getBrand());
					pstmt.setFloat(5, p.getAlcohol());
					pstmt.setInt(6, p.getStock());
					pstmt.setString(7, p.getOrigin());
					pstmt.setInt(8, p.getSweetness());
					pstmt.setInt(9, p.getAcidity());
					pstmt.setInt(10, p.getBody());
					pstmt.setInt(11, p.getTannin());
					pstmt.setString(12, p.getStatus());
					pstmt.setString(13, p.getThumbnail());
					pstmt.setString(14, p.getContentPhoto1());
					pstmt.setString(15, p.getContentPhoto2());
					pstmt.setString(16, p.getContent());
					pstmt.setInt(17, p.getProductNo());
					
					result = pstmt.executeUpdate();
					
				}
				else if(p.getThumbnail() != null && p.getContentPhoto1() == null && p.getContentPhoto2() == null) {
					pstmt = conn.prepareStatement(prop.getProperty("updateProduct2"));
					
					pstmt.setString(1, p.getProductType());
					pstmt.setString(2, p.getProductName());
					pstmt.setInt(3, p.getPrice());
					pstmt.setString(4, p.getBrand());
					pstmt.setFloat(5, p.getAlcohol());
					pstmt.setInt(6, p.getStock());
					pstmt.setString(7, p.getOrigin());
					pstmt.setInt(8, p.getSweetness());
					pstmt.setInt(9, p.getAcidity());
					pstmt.setInt(10, p.getBody());
					pstmt.setInt(11, p.getTannin());
					pstmt.setString(12, p.getStatus());
					pstmt.setString(13, p.getThumbnail());
					pstmt.setString(14, p.getContent());
					pstmt.setInt(15, p.getProductNo());
					
					result = pstmt.executeUpdate();
				}
				else if(p.getThumbnail() == null && p.getContentPhoto1() != null && p.getContentPhoto2() == null) {
					
					pstmt = conn.prepareStatement(prop.getProperty("updateProduct3"));
					
					pstmt.setString(1, p.getProductType());
					pstmt.setString(2, p.getProductName());
					pstmt.setInt(3, p.getPrice());
					pstmt.setString(4, p.getBrand());
					pstmt.setFloat(5, p.getAlcohol());
					pstmt.setInt(6, p.getStock());
					pstmt.setString(7, p.getOrigin());
					pstmt.setInt(8, p.getSweetness());
					pstmt.setInt(9, p.getAcidity());
					pstmt.setInt(10, p.getBody());
					pstmt.setInt(11, p.getTannin());
					pstmt.setString(12, p.getStatus());
					pstmt.setString(13, p.getContentPhoto1());
					pstmt.setString(14, p.getContent());
					pstmt.setInt(15, p.getProductNo());
					
					result = pstmt.executeUpdate();
				}
				else if(p.getThumbnail() == null && p.getContentPhoto1() == null && p.getContentPhoto2() != null) {
					pstmt = conn.prepareStatement(prop.getProperty("updateProduct4"));
					
					pstmt.setString(1, p.getProductType());
					pstmt.setString(2, p.getProductName());
					pstmt.setInt(3, p.getPrice());
					pstmt.setString(4, p.getBrand());
					pstmt.setFloat(5, p.getAlcohol());
					pstmt.setInt(6, p.getStock());
					pstmt.setString(7, p.getOrigin());
					pstmt.setInt(8, p.getSweetness());
					pstmt.setInt(9, p.getAcidity());
					pstmt.setInt(10, p.getBody());
					pstmt.setInt(11, p.getTannin());
					pstmt.setString(12, p.getStatus());
					pstmt.setString(13, p.getContentPhoto2());
					pstmt.setString(14, p.getContent());
					pstmt.setInt(15, p.getProductNo());
					
					result = pstmt.executeUpdate();				
				}
				else if(p.getThumbnail() != null && p.getContentPhoto1() != null && p.getContentPhoto2() == null) {
					pstmt = conn.prepareStatement(prop.getProperty("updateProduct5"));
					
					pstmt.setString(1, p.getProductType());
					pstmt.setString(2, p.getProductName());
					pstmt.setInt(3, p.getPrice());
					pstmt.setString(4, p.getBrand());
					pstmt.setFloat(5, p.getAlcohol());
					pstmt.setInt(6, p.getStock());
					pstmt.setString(7, p.getOrigin());
					pstmt.setInt(8, p.getSweetness());
					pstmt.setInt(9, p.getAcidity());
					pstmt.setInt(10, p.getBody());
					pstmt.setInt(11, p.getTannin());
					pstmt.setString(12, p.getStatus());
					pstmt.setString(13, p.getThumbnail());
					pstmt.setString(14, p.getContentPhoto1());
					pstmt.setString(15, p.getContent());
					pstmt.setInt(16, p.getProductNo());
					
					result = pstmt.executeUpdate();
				}
				else if(p.getThumbnail() == null && p.getContentPhoto1() != null && p.getContentPhoto2() != null) {
					pstmt = conn.prepareStatement(prop.getProperty("updateProduct6"));
					
					pstmt.setString(1, p.getProductType());
					pstmt.setString(2, p.getProductName());
					pstmt.setInt(3, p.getPrice());
					pstmt.setString(4, p.getBrand());
					pstmt.setFloat(5, p.getAlcohol());
					pstmt.setInt(6, p.getStock());
					pstmt.setString(7, p.getOrigin());
					pstmt.setInt(8, p.getSweetness());
					pstmt.setInt(9, p.getAcidity());
					pstmt.setInt(10, p.getBody());
					pstmt.setInt(11, p.getTannin());
					pstmt.setString(12, p.getStatus());
					pstmt.setString(13, p.getContentPhoto1());
					pstmt.setString(14, p.getContentPhoto2());
					pstmt.setString(15, p.getContent());
					pstmt.setInt(16, p.getProductNo());
					
					result = pstmt.executeUpdate();
					
				}
				else if(p.getThumbnail() != null && p.getContentPhoto1() == null && p.getContentPhoto2() != null) {
					pstmt = conn.prepareStatement(prop.getProperty("updateProduct7"));
					
					pstmt.setString(1, p.getProductType());
					pstmt.setString(2, p.getProductName());
					pstmt.setInt(3, p.getPrice());
					pstmt.setString(4, p.getBrand());
					pstmt.setFloat(5, p.getAlcohol());
					pstmt.setInt(6, p.getStock());
					pstmt.setString(7, p.getOrigin());
					pstmt.setInt(8, p.getSweetness());
					pstmt.setInt(9, p.getAcidity());
					pstmt.setInt(10, p.getBody());
					pstmt.setInt(11, p.getTannin());
					pstmt.setString(12, p.getStatus());
					pstmt.setString(13, p.getThumbnail());
					pstmt.setString(14, p.getContentPhoto2());
					pstmt.setString(15, p.getContent());
					pstmt.setInt(16, p.getProductNo());
					
					result = pstmt.executeUpdate();
					
				}
				else {
					pstmt = conn.prepareStatement(prop.getProperty("updateProduct8"));
					
					pstmt.setString(1, p.getProductType());
					pstmt.setString(2, p.getProductName());
					pstmt.setInt(3, p.getPrice());
					pstmt.setString(4, p.getBrand());
					pstmt.setFloat(5, p.getAlcohol());
					pstmt.setInt(6, p.getStock());
					pstmt.setString(7, p.getOrigin());
					pstmt.setInt(8, p.getSweetness());
					pstmt.setInt(9, p.getAcidity());
					pstmt.setInt(10, p.getBody());
					pstmt.setInt(11, p.getTannin());
					pstmt.setString(12, p.getStatus());
					pstmt.setString(13, p.getContent());
					pstmt.setInt(14, p.getProductNo());
					
					result = pstmt.executeUpdate();
				}
					
	
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
	//5. ??????'??????'??? ?????? ????????? 
	public ArrayList<Product> sortProductType(Connection conn) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sortProductType");
		
		try {
			pstmt = conn.prepareStatement(sql);
	
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_TYPE"),
										rset.getString("PRODUCT_NAME"),
										rset.getInt("PRICE"),
										rset.getString("BRAND"),
										rset.getFloat("ALCOHOL"),
										rset.getInt("STOCK"),
										rset.getString("ORIGIN"),
										rset.getInt("SWEETNESS"),
										rset.getInt("ACIDITY"),
										rset.getInt("BODY"),
										rset.getInt("TANNIN"),
										rset.getString("STATUS"),
										rset.getInt("COUNT"),
										rset.getString("THUMBNAIL"),
										rset.getString("CONTENT_PHOTO1"),
										rset.getString("CONTENT_PHOTO2"),
										rset.getString("CONTENT"));
	
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	// 6. ??????'???'??? ?????? ?????????
	public ArrayList<Product> sortProductTaste(Connection conn){
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sortProductTaste");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
					Product p = new Product(rset.getInt("PRODUCT_NO"),
							rset.getString("PRODUCT_TYPE"),
							rset.getString("PRODUCT_NAME"),
							rset.getInt("PRICE"),
							rset.getString("BRAND"),
							rset.getFloat("ALCOHOL"),
							rset.getInt("STOCK"),
							rset.getString("ORIGIN"),
							rset.getInt("SWEETNESS"),
							rset.getInt("ACIDITY"),
							rset.getInt("BODY"),
							rset.getInt("TANNIN"),
							rset.getString("STATUS"),
							rset.getInt("COUNT"),
							rset.getString("THUMBNAIL"),
							rset.getString("CONTENT_PHOTO1"),
							rset.getString("CONTENT_PHOTO2"),
							rset.getString("CONTENT"));
		
					list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	// 7. ??????'??????'??? ?????? ?????????
	public ArrayList<Product> sortProductOrigin(Connection conn) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sortProductOrigin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_TYPE"),
										rset.getString("PRODUCT_NAME"),
										rset.getInt("PRICE"),
										rset.getString("BRAND"),
										rset.getFloat("ALCOHOL"),
										rset.getInt("STOCK"),
										rset.getString("ORIGIN"),
										rset.getInt("SWEETNESS"),
										rset.getInt("ACIDITY"),
										rset.getInt("BODY"),
										rset.getInt("TANNIN"),
										rset.getString("STATUS"),
										rset.getInt("COUNT"),
										rset.getString("THUMBNAIL"),
										rset.getString("CONTENT_PHOTO1"),
										rset.getString("CONTENT_PHOTO2"),
										rset.getString("CONTENT"));

				list.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// 8. ??????'??????'??? ?????? ?????????
	public ArrayList<Product> sortProductPrice(Connection conn) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sortProductPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
							rset.getString("PRODUCT_TYPE"),
							rset.getString("PRODUCT_NAME"),
							rset.getInt("PRICE"),
							rset.getString("BRAND"),
							rset.getFloat("ALCOHOL"),
							rset.getInt("STOCK"),
							rset.getString("ORIGIN"),
							rset.getInt("SWEETNESS"),
							rset.getInt("ACIDITY"),
							rset.getInt("BODY"),
							rset.getInt("TANNIN"),
							rset.getString("STATUS"),
							rset.getInt("COUNT"),
							rset.getString("THUMBNAIL"),
							rset.getString("CONTENT_PHOTO1"),
							rset.getString("CONTENT_PHOTO2"),
							rset.getString("CONTENT"));
	
				list.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	
	public int revisionStockCount(Connection conn, int productNo, int count) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("revisionStockCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setInt(2, count);
			pstmt.setInt(3, productNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	// ????????? - ?????? ?????? ????????? ??????
	public ArrayList<Product> selectProduct(Connection conn, String searchWord) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + searchWord + "%");
			pstmt.setString(2, "%" + searchWord + "%");
			pstmt.setString(3, "%" + searchWord + "%");
//			pstmt.setString(4, "%" + searchWord + "%");
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_TYPE"),
										rset.getString("PRODUCT_NAME"),
										rset.getInt("PRICE"),
										rset.getString("BRAND"),
										rset.getFloat("ALCOHOL"),
										rset.getInt("STOCK"),
										rset.getString("ORIGIN"),
										rset.getInt("SWEETNESS"),
										rset.getInt("ACIDITY"),
										rset.getInt("BODY"),
										rset.getInt("TANNIN"),
										rset.getString("STATUS"),
										rset.getInt("COUNT"),
										rset.getString("THUMBNAIL"),
										rset.getString("CONTENT_PHOTO1"),
										rset.getString("CONTENT_PHOTO2"),
										rset.getString("CONTENT"));

				list.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;	
	}
	
	// ????????? ?????????
		public int selectListCount(Connection conn) {
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
	
	
	// ????????? ???????????? ????????? ??????
	public ArrayList<Product> selectProduct(Connection conn, PageInfo pi) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductPage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			/*
			 * boardLimit ??? 10 ????????? ?????? ??????
			 * currentPage : 1 => ????????? 1, ?????? 10
			 * currentPage : 2 => ????????? 11, ?????? 20
			 * currentPage : 3 => ????????? 21, ?????? 30
			 * ...
			 * 
			 * ????????? = (currentPage - 1) * boardLimit + 1
			 * ?????? = ????????? + boardLimit - 1
			 */
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_TYPE"),
										rset.getString("PRODUCT_NAME"),
										rset.getInt("PRICE"),
										rset.getString("BRAND"),
										rset.getFloat("ALCOHOL"),
										rset.getInt("STOCK"),
										rset.getString("ORIGIN"),
										rset.getInt("SWEETNESS"),
										rset.getInt("ACIDITY"),
										rset.getInt("BODY"),
										rset.getInt("TANNIN"),
										rset.getString("STATUS"),
										rset.getInt("COUNT"),
										rset.getString("THUMBNAIL"),
										rset.getString("CONTENT_PHOTO1"),
										rset.getString("CONTENT_PHOTO2"),
										rset.getString("CONTENT"));

				list.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;	
	}
	
	
	// ??????
	// 2. ProductList??? ????????? ????????? 
	public ArrayList<Product> selectList(Connection conn, PageNation pn) {
		
		ArrayList<Product> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pn.getCurrentPage()-1) * pn.getBoardLimit() + 1;
			int endRow = startRow + pn.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_TYPE"),
										rset.getString("PRODUCT_NAME"),
										rset.getInt("PRICE"),
										rset.getString("BRAND"),
										rset.getFloat("ALCOHOL"),
										rset.getInt("STOCK"),
										rset.getString("ORIGIN"),
										rset.getInt("SWEETNESS"),
										rset.getInt("ACIDITY"),
										rset.getInt("BODY"),
										rset.getInt("TANNIN"),
										rset.getString("STATUS"),
										rset.getInt("COUNT"),
										rset.getString("THUMBNAIL"),
										rset.getString("CONTENT_PHOTO1"),
										rset.getString("CONTENT_PHOTO2"),
										rset.getString("CONTENT"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;	
	}
	
	
	//5. ??????'??????'??? ?????? ????????? 
	public ArrayList<Product> sortProductType(Connection conn, PageNation pn) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sortProductType");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pn.getCurrentPage()-1) * pn.getBoardLimit() + 1;
			int endRow = startRow + pn.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
	
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_TYPE"),
										rset.getString("PRODUCT_NAME"),
										rset.getInt("PRICE"),
										rset.getString("BRAND"),
										rset.getFloat("ALCOHOL"),
										rset.getInt("STOCK"),
										rset.getString("ORIGIN"),
										rset.getInt("SWEETNESS"),
										rset.getInt("ACIDITY"),
										rset.getInt("BODY"),
										rset.getInt("TANNIN"),
										rset.getString("STATUS"),
										rset.getInt("COUNT"),
										rset.getString("THUMBNAIL"),
										rset.getString("CONTENT_PHOTO1"),
										rset.getString("CONTENT_PHOTO2"),
										rset.getString("CONTENT"));
	
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	// 6. ??????'???'??? ?????? ?????????
	public ArrayList<Product> sortProductTaste(Connection conn, PageNation pn){
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sortProductTaste");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pn.getCurrentPage()-1) * pn.getBoardLimit() + 1;
			int endRow = startRow + pn.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
					Product p = new Product(rset.getInt("PRODUCT_NO"),
							rset.getString("PRODUCT_TYPE"),
							rset.getString("PRODUCT_NAME"),
							rset.getInt("PRICE"),
							rset.getString("BRAND"),
							rset.getFloat("ALCOHOL"),
							rset.getInt("STOCK"),
							rset.getString("ORIGIN"),
							rset.getInt("SWEETNESS"),
							rset.getInt("ACIDITY"),
							rset.getInt("BODY"),
							rset.getInt("TANNIN"),
							rset.getString("STATUS"),
							rset.getInt("COUNT"),
							rset.getString("THUMBNAIL"),
							rset.getString("CONTENT_PHOTO1"),
							rset.getString("CONTENT_PHOTO2"),
							rset.getString("CONTENT"));
		
					list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	// 7. ??????'??????'??? ?????? ?????????
	public ArrayList<Product> sortProductOrigin(Connection conn, PageNation pn) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sortProductOrigin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pn.getCurrentPage()-1) * pn.getBoardLimit() + 1;
			int endRow = startRow + pn.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_TYPE"),
										rset.getString("PRODUCT_NAME"),
										rset.getInt("PRICE"),
										rset.getString("BRAND"),
										rset.getFloat("ALCOHOL"),
										rset.getInt("STOCK"),
										rset.getString("ORIGIN"),
										rset.getInt("SWEETNESS"),
										rset.getInt("ACIDITY"),
										rset.getInt("BODY"),
										rset.getInt("TANNIN"),
										rset.getString("STATUS"),
										rset.getInt("COUNT"),
										rset.getString("THUMBNAIL"),
										rset.getString("CONTENT_PHOTO1"),
										rset.getString("CONTENT_PHOTO2"),
										rset.getString("CONTENT"));

				list.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// 8. ??????'??????'??? ?????? ?????????
	public ArrayList<Product> sortProductPrice(Connection conn, PageNation pn) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sortProductPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pn.getCurrentPage()-1) * pn.getBoardLimit() + 1;
			int endRow = startRow + pn.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
							rset.getString("PRODUCT_TYPE"),
							rset.getString("PRODUCT_NAME"),
							rset.getInt("PRICE"),
							rset.getString("BRAND"),
							rset.getFloat("ALCOHOL"),
							rset.getInt("STOCK"),
							rset.getString("ORIGIN"),
							rset.getInt("SWEETNESS"),
							rset.getInt("ACIDITY"),
							rset.getInt("BODY"),
							rset.getInt("TANNIN"),
							rset.getString("STATUS"),
							rset.getInt("COUNT"),
							rset.getString("THUMBNAIL"),
							rset.getString("CONTENT_PHOTO1"),
							rset.getString("CONTENT_PHOTO2"),
							rset.getString("CONTENT"));
	
				list.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public ArrayList<Product> selectBestSellerProduct(Connection conn) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBestSellerProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_TYPE"),
										rset.getString("PRODUCT_NAME"),
										rset.getInt("PRICE"),
										rset.getString("BRAND"),
										rset.getFloat("ALCOHOL"),
										rset.getInt("STOCK"),
										rset.getString("ORIGIN"),
										rset.getInt("SWEETNESS"),
										rset.getInt("ACIDITY"),
										rset.getInt("BODY"),
										rset.getInt("TANNIN"),
										rset.getString("STATUS"),
										rset.getInt("COUNT"),
										rset.getString("THUMBNAIL"),
										rset.getString("CONTENT_PHOTO1"),
										rset.getString("CONTENT_PHOTO2"),
										rset.getString("CONTENT"));

				list.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
