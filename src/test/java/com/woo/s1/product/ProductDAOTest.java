package com.woo.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.woo.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase {

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getProductListTest() throws Exception {
		List<ProductDTO> ar = productDAO.getProductList();
		System.out.println(ar.size()>0);
		
		// 단정문
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getProductDetail() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(29L);
		productDTO = productDAO.getProductDetail(productDTO);
		assertNotNull(productDTO);
	}
	
	// Insert
	@Test
	public void setProductAddTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(2L);
		productDTO.setProductName("Test");
		productDTO.setProductDetail("TestDetail");
		int result = productDAO.setProductAdd(productDTO);
		assertEquals(1, result);
	}

}
