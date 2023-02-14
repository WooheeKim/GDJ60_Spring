package com.woo.s1.member;

import java.util.List;

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
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/memberAdd");
		return mv;
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
		HttpSession session = request.getSession();
		session.setAttribute("member", memberDTO);
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
	
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberPage() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberLogout");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		memberDTO = memberService.setMemberUpdate(memberDTO);
		modelAndView.setViewName("redirect:../memberMypage");
		return modelAndView;
	}
}
