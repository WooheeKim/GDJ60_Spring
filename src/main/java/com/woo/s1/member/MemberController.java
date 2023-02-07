package com.woo.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void getMemberJoin() {
		System.out.println("Member Join");
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String getMemberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberService.setMemberAdd(memberDTO);
		System.out.println("Member Join");
		System.out.println(result==1);
		return "redirect:./memberList";
	}
	
	@RequestMapping(value = "memberList")
	public ModelAndView memberList(ModelAndView modelAndView) throws Exception {
		List<MemberDTO> ar = memberService.getMemberList();
		System.out.println(ar.size()>0);
		modelAndView.addObject("memberList",ar);
		modelAndView.setViewName("member/memberList");
		return modelAndView;
	}
	
	@RequestMapping(value = "page")
	public ModelAndView getMemberPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
	
}
