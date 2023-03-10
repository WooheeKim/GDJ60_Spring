package com.woo.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.woo.s1.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list")
	public ModelAndView getProductList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ProductDTO> ar = productService.getProductList(pager);
		
		System.out.println(ar.size()>0);
		modelAndView.setViewName("product/productList"); // jsp 설정
		modelAndView.addObject("list", ar); // list 변수 jsp로 보냄 attribute랑 같은 역할
		modelAndView.addObject("pager", pager);
		return modelAndView; 
	}
	
	// String 방식
	@RequestMapping(value = "detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		
		System.out.println("Product Detail");
		
		productDTO = productService.getProductDetail(productDTO);
		
		System.out.println(productDTO != null);
		
		model.addAttribute("dto", productDTO);
		
		return "product/productDetail";
	}
	
	// void 방식
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void setProductAdd() {
		// 자동으로 url 주소를 이용하여 jsp 파일을 찾아줌	
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String setProductAdd(ProductDTO productDTO) throws Exception {
		int result = productService.setProductAdd(productDTO, null);
		System.out.println(result==1);
		return "redirect:./list";
	}
	
	// ModelAndView 방식 
	@RequestMapping(value = "update")
	public ModelAndView update() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product/productUpdate");
		return modelAndView;
	}
	
}
