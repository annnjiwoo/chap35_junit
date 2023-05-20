package com.javalab.board.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.javalab.board.dao.BoardDao;
import com.javalab.board.vo.BoardVo;


@Controller
public class BoardController {

//	@Autowired
//	private BoardService boardService;

	@Autowired
	private BoardDao dao;
	
	// 기본 생성자
	public BoardController() {
		System.out.println("BoardController 생성자");
	}
	
	/*
	 * 게시물 목록을 보여주는 메소드(핸들러)
	 * @RequestMapping :
	 *  - 요청이 왔을 때 어떤 컨트롤러가 호출이 되어야 하는지 알려주는 지표. 
	 *  - 어플리케이션이 구동되면서 RequestMappingHandlerMapping에게 어떤 메소드에 어떤
	 *    매핑정보(url)있는 지 찾아서 알려주는 역할. 
	 */
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String selectBoardList(Model model){
		ArrayList<BoardVo> boardList = dao.selectBoardList();
		model.addAttribute("boardList", boardList);
		return "boardList";	// boardList.jsp
	}
	
	// 게시물 한개의 내용을 보여주는 메소드(핸들러)
	// @RequestParam : @RequestParam("받아올 데이터의 이름") [데이터타입] [가져온데이터를 담을 변수]
	@RequestMapping(value="/boardView.do", method = RequestMethod.GET)
	public String getBoardById(@RequestParam("no") int no, Model model){
		BoardVo boardVo = dao.getBoardById(no);
		model.addAttribute("board", boardVo);
		return "boardView";	// boardView.jsp
	}
	
	// 게시물 작성 폼을 띄워주는 메소드(핸들러)
	@RequestMapping(value="/boardWrite.do", method = RequestMethod.GET)
	public String boardWriteForm(Model model){
		return "boardWrite";	// boardWrite.jsp
	}

	// 작성된 게시물을 데이터베이스에 저장하는 메소드(핸들러)
	@RequestMapping(value="/boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(BoardVo vo, Model model){
		dao.insertBoard(vo);
		return "redirect:boardList.do"; 
	}

	// 수정폼을 보여주는 메소드(핸들러)
	@RequestMapping(value="/boardModify.do", method = RequestMethod.GET)
	public String boardModifyForm(@RequestParam("no") int no, Model model){
		// 게시물 목록을 조회
		BoardVo boardVo = dao.getBoardById(no);
		model.addAttribute("board", boardVo);
		return "boardModify";	// boardModify.jsp
	}
	
	// 수정한 내용을 데이터베이스에 반영하는 메소드(핸들러)
	@RequestMapping(value="/boardModify.do", method = RequestMethod.POST)
	public String boardModify(BoardVo vo, Model model){
		dao.modifyBoard(vo);
		return "redirect:boardList.do"; 
	}

	// 게시물을 삭제해주는 메소드(핸들러)
	@RequestMapping(value="/boardDelete.do", method = RequestMethod.GET)
	public String boardModify(@RequestParam("no") int no){
		dao.deleteBoard(no);
		return "redirect:boardList.do"; 
	}
}
