package com.woo.s1.bankBook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.woo.s1.util.Pager;

@Controller
@RequestMapping("/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBankBookList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BankBookDTO> ar = bankBookService.getBankBookList(pager);
		
		modelAndView.setViewName("bankBook/list");
		modelAndView.addObject("list", ar);
		modelAndView.addObject("pager", pager);
		return modelAndView;
		
	}
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		
		modelAndView.setViewName("bankBook/detail");
		modelAndView.addObject("dto", bankBookDTO);
		
		return modelAndView;
	}
	
	// add form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView setBankBookAdd(ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("bankBook/add");
		
		return modelAndView; 
	}
	// add DB Insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile pic, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("Name : "+pic.getName());
		System.out.println("OriName : "+pic.getOriginalFilename());
		System.out.println("Size : "+pic.getSize());
		System.out.println(session.getServletContext());
		
		int result = bankBookService.setBankBookAdd(bankBookDTO, pic);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	// delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	// 수정 폼 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		modelAndView.setViewName("bankBook/update");
		modelAndView.addObject("dto", bankBookDTO);
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		int result = bankBookService.setBankBookUpdate(bankBookDTO);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
}
