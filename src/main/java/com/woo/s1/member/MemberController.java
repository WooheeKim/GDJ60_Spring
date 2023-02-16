package com.woo.s1.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberAdd", method = RequestMethod.GET)
	public ModelAndView setMemberAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberAdd");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberAdd", method = RequestMethod.POST)
	public ModelAndView setMemberAdd(MemberDTO memberDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = memberService.setMemberAdd(memberDTO);
		
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public ModelAndView getMemberLogin() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberLogin");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		memberDTO = memberService.getMemberLogin(memberDTO);
		if(memberDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
		}
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		session.invalidate();
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("/member/memberPage");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public ModelAndView getMemberUpdate(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("/member/memberUpdate");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView getMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO sessionMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMemberDTO.getId());
		int result = memberService.setMemberUpdate(memberDTO);
//		if(result>0) {
//			session.setAttribute("member", memberDTO);
//		}
		modelAndView.setViewName("redirect:./memberPage");
		return modelAndView;
	}
}
