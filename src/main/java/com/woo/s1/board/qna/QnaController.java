package com.woo.s1.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.woo.s1.board.BbsDTO;
import com.woo.s1.board.BoardDTO;
import com.woo.s1.board.BoardFileDTO;
import com.woo.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(@ModelAttribute Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("board/list");
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		// URL, Method, parameter, header
		
		// Header
		HttpHeaders headers = new HttpHeaders();
		// 1. headers.add("header명", "header값");
		// 2. headers.set헤드명("header값");
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		// parameter(post)
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("파라미터명", "파라미터값");
		params.add("grant_type", "authorization_code");
		params.add("client_id", "${REST_API_KEY}");
		
		// header, params 하나의 객체로 생성
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params, headers); 
		
		String result = restTemplate.getForObject("https://dummyjson.com/products/1", String.class, request, String.class);
		// String result = restTemplate.postForObject("https://dummyjson.com/products/1", String.class, request, String.class);
		System.out.println(result);
		
		
		return modelAndView;
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/add");
		return modelAndView;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile [] addFiles, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = qnaService.setBoardAdd(qnaDTO, addFiles, session);
		
		String message = "등록 실패";
		
		if(result>0) {
			message = "글이 등록 되었습니다.";
		}
		
		modelAndView.addObject("result", message);
		modelAndView.addObject("url", "./list");
		modelAndView.setViewName("common/result");
		return modelAndView;
		
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		BoardDTO boardDTO = qnaService.getBoardDetail(qnaDTO);
		modelAndView.addObject("dto", boardDTO);
		modelAndView.setViewName("board/detail");
		
		return modelAndView;
	}
	
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO boardDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("board/reply");
		return modelAndView;
		
	}
	
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = qnaService.setReplyAdd(qnaDTO);
		
		String message = "등록 실패";
		
		if(result>0) {
			message = "글이 등록 되었습니다.";
		}
		
		modelAndView.setViewName("common/result");
		modelAndView.addObject("result", message);
		modelAndView.addObject("url","./detail?num="+qnaDTO.getNum());
		return modelAndView;	
	}
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("common/result");
		
		int result = qnaService.setBoardDelete(bbsDTO, session);
		
		String message = "삭제 실패";
		
		if(result>0) {
			message = "삭제되었습니다.";
		}
		
		modelAndView.addObject("result", message);
		modelAndView.addObject("url", "./list");
		
		return modelAndView;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		
		modelAndView.addObject("boardFile", boardFileDTO);
		modelAndView.setViewName("fileDownView");
		
		
		return modelAndView;
	}
	
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		boardDTO = qnaService.getBoardDetail(boardDTO);
		
		modelAndView.addObject("dto", boardDTO);
		modelAndView.setViewName("board/update");
		
		return modelAndView;
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO, MultipartFile [] addFiles, HttpSession session, Long [] fileNum) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = qnaService.setBoardUpdate(boardDTO, addFiles, session, fileNum);
		
		modelAndView.setViewName("common/result");
		modelAndView.addObject("result", "수정 성공");
		modelAndView.addObject("url", "./list");
		
		return modelAndView;
	}
	
	//====================================================================
	
	@PostMapping("boardFileDelete")
	public ModelAndView setBoardFileDelete(Long fileNum) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = qnaService.setBoardFileDelete(fileNum);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("common/ajaxResult");		
		
		return modelAndView;
	}
	
}
