package com.woo.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list")
	public ModelAndView getProductList() throws Exception {
		
		System.out.println("Product List");
		List<ProductDTO> ar = productService.getProductList();
		System.out.println(ar.size()>0);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product/productList"); // jsp 설정
		modelAndView.addObject("list", ar); // list 변수 jsp로 보냄 attribute랑 같은 역할
		
		return modelAndView; 
	}
	
	// String 방식
	@RequestMapping(value = "detail")
	public String getProductDetail() {
		System.out.println("Product Detail");
		return "product/productDetail";
	}
	
	
	
	// void 방식
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void productAdd() {
		// 자동으로 url 주소를 이용하여 jsp 파일을 찾아줌	
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String productAdd(ProductDTO productDTO) throws Exception {
		int result = productService.setAddProduct(productDTO, null);
		System.out.println(result==1);
		return "redirect:./list";
	}
	
	// ModelAndView 방식 
	@RequestMapping(value = "update")
	public ModelAndView getProductUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
	
}
