package com.woo.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.woo.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
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
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCTNUM=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, productDTO.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getInt("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			productDTO.setProductDetail(rs.getString("PRODUCTDETAIL"));
		} else {
			productDTO = null;
		}
		DBConnection.disConnect(rs, st, connection);
		return productDTO;
	}
	
	
	public List<ProductDTO> getProductList() throws Exception{
		
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTJUMSU "
				+ "FROM PRODUCT ORDER BY PRODUCTJUMSU DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getInt("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			ar.add(productDTO);
			
		}
		DBConnection.disConnect(rs, st, connection);
		
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
