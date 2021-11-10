package com.iu.b5.board.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b5.board.BoardService;
import com.iu.b5.board.BoardVO;
import com.iu.b5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	//접근지정자 그외지정자 리턴타입 메서드명(매개변수선언){}
	
	@GetMapping("insert")
	public String setInsert(@ModelAttribute BoardVO boardVO)throws Exception{
		return "board/insert";
	}
	
	@PostMapping("insert")
	public String setInsert(@Valid BoardVO boardVO,BindingResult bindingResult , MultipartFile [] files)throws Exception{

		if(bindingResult.hasErrors()) {
			return "board/insert";
		}
		
		int result = qnaService.setInsert(boardVO, files);
		
		if(result>0) {
			
		}
		
		return "redirect:./selectList";
		
	}
	
	@GetMapping("reply")
	public String reply(@ModelAttribute BoardVO boardVO)throws Exception{
		
		return "board/reply";
	}
	
	@PostMapping("reply")
	public String reply(@Valid BoardVO boardVO, BindingResult bindingResult, MultipartFile [] files)throws Exception{
		
		if(bindingResult.hasErrors()) {
			return "board/reply";
		}
		
		int result = qnaService.setReplyInsert(boardVO, files);
		
		return "redirect:./selectList";
		
	}
	
	
	@GetMapping("update")
	public String setUpdate(BoardVO boardVO, Model model)throws Exception{
		boardVO = qnaService.getSelectOne(boardVO);
		model.addAttribute("boardVO", boardVO);
		
		return "board/update";
	}
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO)throws Exception{
		int result = qnaService.setUpdate(boardVO);
		return "redirect:./selectOne?num="+boardVO.getNum();
	}
	
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO)throws Exception{
		int result = qnaService.setDelete(boardVO);
		return "redirect:./selectList";
	}
	
	@GetMapping("selectOne")
	public ModelAndView getSelectOne(BoardVO boardVO)throws Exception{
		//String num = request.getParameter("num");//많이요
		//int n = Integer.parseInt(num);
		//BoardVO boardVO = new BoardVO();
		//boardVO.setNum(num);
		ModelAndView mv = new ModelAndView();
		boardVO = qnaService.getSelectOne(boardVO);
		//
		
		mv.setViewName("board/select");
		mv.addObject("boardVO", boardVO);
		return mv;
	}
	
	@GetMapping("selectList")
	public ModelAndView getSelectList(Pager pager, ModelAndView mv)throws Exception{
		//kind : column
		//search : 검색어
		List<BoardVO> ar = qnaService.getSelectList(pager);
		mv.setViewName("board/list");
		mv.addObject("boardList", ar);
		mv.addObject("pager", pager);
		return mv;
	}
	
	

}
