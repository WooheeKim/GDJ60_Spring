package com.woo.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getProductDetail(productDTO);
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		return productDAO.getProductList();
	}
	
	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		int productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setAddProduct(productDTO);
		
		for(ProductOptionDTO productOptionDTO:ar) {
			productDAO.setAddProductOption(productOptionDTO);
			result = productDAO.setAddProductOption(productOptionDTO);
		}
		
		return result;
	}

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOptionName("optionName1");
		productOptionDTO.setOptionPrice(100);
		productOptionDTO.setOptionStock(10.0);
		productOptionDTO.setProductNum(null);
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO2.setOptionName("optionName2");
		productOptionDTO.setOptionPrice(200);
		productOptionDTO.setOptionStock(20.0);
		productOptionDTO.setProductNum(null);
		
		try {
			int num = productDAO.getProductNum();
			
			productDTO.setProductNum(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setOptionNum(num);
			
			if(result>0) {
				productDAO.setAddProductOption(productOptionDTO);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
