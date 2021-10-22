package controller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class BoardController {
	
	@ModelAttribute("sm")
	// 국제화
	public Map<String,String>searchMap(){
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}
	
	@RequestMapping("/Main.do")
	public String getBoardList(@RequestParam(value="condition",defaultValue="title",required=false)String condition,@RequestParam(value="keyword",defaultValue="",required=false)String keyword,BoardVO vo,BoardDAO dao,Model model) {
		System.out.println(condition+": "+keyword);
		List<BoardVO> datas=dao.getBoardList(new BoardVO());
		model.addAttribute("datas", datas);
		return "main";

	}
	/*@RequestMapping("/Main.do")
	public ModelAndView getBoardList(BoardVO vo,BoardDAO dao,ModelAndView mav) {
		System.out.println(vo.getCondition()+": "+vo.getKeyword());
		if(vo.getCondition()==null) {
			vo.setCondition("title");
		}
		List<BoardVO> datas=dao.getBoardList(new BoardVO());
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;

	}*/
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDAO dao,BoardVO vo,Model model) {
		BoardVO data=dao.getBoard(vo);
		model.addAttribute("data", data);
		return "getBoard";
	}
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAO dao) {
		dao.insertBoard(vo);
		return "redirect:main.do";

	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo,BoardDAO dao){
		dao.deleteBoard(vo);
		return("redirect:main.do");
	}
	@RequestMapping("/UpdateBoard.do")
	public String updateBoard(BoardVO vo,BoardDAO dao) {
		dao.updateBoard(vo);
		return("redirect:main.do");

	}

}
