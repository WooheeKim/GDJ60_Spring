package com.woo.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBankBookList(ModelAndView modelAndView) throws Exception {
		
		List<BankBookDTO> ar = bankBookService.getBankBookList();
		
		System.out.println(ar.size()>0);
		modelAndView.setViewName("bankBook/list");
		modelAndView.addObject("list",ar);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBankBookDetail(ModelAndView modelAndView, BankBookDTO bankBookDTO) throws Exception {
		
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		
		modelAndView.setViewName("bankBook/detail");
		
		modelAndView.addObject(bankBookDTO);
		
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
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = bankBookService.setBankBookAdd(bankBookDTO);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update")
	public ModelAndView setBankBookUpdate() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bankBook/update");
		return modelAndView;
	}
	
}
