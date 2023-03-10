package com.woo.s1.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.woo.s1.board.BbsDTO;
import com.woo.s1.board.BbsService;
import com.woo.s1.member.MemberDTO;
import com.woo.s1.util.Pager;


@Controller
@RequestMapping("/bankBookComment/*")
public class BankBookCommentController {
	
	@Autowired
	private BbsService bankBookCommentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> ar = bankBookCommentService.getBoardList(pager);
		
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("common/commentList");
		
		return modelAndView;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//bankBookCommentDTO.setWriter(memberDTO.getId());
		bankBookCommentDTO.setWriter(memberDTO.getId());
		System.out.println("num : "+bankBookCommentDTO.getBookNumber());
		int result = bankBookCommentService.setBoardAdd(bankBookCommentDTO, null, null);				
		modelAndView.addObject("result", result);
		modelAndView.setViewName("common/ajaxResult");
		
		return modelAndView;
	}
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = bankBookCommentService.setBoardDelete(bankBookCommentDTO, null);
		
		modelAndView.addObject("result", result);
		modelAndView.setViewName("common/ajaxResult");
		
		return modelAndView;
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = bankBookCommentService.setBoardUpdate(bankBookCommentDTO);
		
		modelAndView.addObject("result", result);
		modelAndView.setViewName("common/ajaxResult");
		
		return modelAndView;
	}
	
	
}
