package com.woo.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private DataSource dataSource;
	
	
	// delete
	public int setProductDelete(int productNum) throws Exception {
		int result = 0;
		
		// 1. DB연결
		Connection connection = DBConnection.getConnection();
		// 2. SQL 생성
		String sql = "DELETE PRODUCT WHERE PRODUCTNUM=?";
		// 3. SQL 미리보내기
		PreparedStatement st = connection.prepareStatement(sql);
		// 4. ? 셋팅
		st.setInt(1, productNum);
		// 5. 최종 전송 및 결과 처리
		result = st.executeUpdate();
		// 6. 연결 해제
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	public int getProductNum() throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		int num =  rs.getInt(1);
		
		DBConnection.disConnect(rs, st, connection);
		
		return num;
		
	}
	
	
	public List<ProductOptionDTO> getProductOptionList() throws Exception {
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getInt("OPTIONNUM"));
			productOptionDTO.setProductNum(rs.getInt("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getInt("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getDouble("OPTIONSTOCK"));
			ar.add(productOptionDTO);
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return ar;
		
	}
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK) "
				+ "VALUES (PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, productOptionDTO.getProductNum());
		st.setString(2, productOptionDTO.getOptionName());
		st.setInt(3, productOptionDTO.getOptionPrice());
		st.setDouble(4, productOptionDTO.getOptionStock());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		
		return productDTO;
	}
	
	
	public List<ProductDTO> getProductList() throws Exception{
		
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		return ar;
	}
	
	
	public int setAddProduct(ProductDTO productDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT (PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU) "
				+ "VALUES (?, ?, ?, 0.0)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
//		st.setDouble(4, productDTO.getProductJumsu());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	
	
}
