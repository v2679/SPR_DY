package com.dy.controller;
// sdfsafsdfsdsad
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dy.service.BoardService;
import com.dy.service.ReplyService;
import com.dy.model.BoardVO;
import com.dy.model.Criteria;
import com.dy.model.PageVO;
import com.dy.model.ReplyVO;

@Controller
@RequestMapping("/member")
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	@Autowired
	private ReplyService rservice;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public void listGet(Model model)throws Exception{
		System.out.println("bservice.listList()="+bservice.listList());
		model.addAttribute("list",bservice.listList());
	}
	/*
	//게시글 목록 리스트(페이징)
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void listGet(Criteria cri,Model model)throws Exception{
		int total=bservice.boardCount(cri);
		PageVO pv = new PageVO(cri,total);
		
		model.addAttribute("list",bservice.boardList(cri));
		model.addAttribute("page",pv);
	}
	*/
	/*글쓰기를 위한 컨트롤러*/
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String writeGet()throws Exception{
		logger.info("write get.........");
		return "member/write";
	}
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String writePost(BoardVO board,MultipartHttpServletRequest mpRequest)throws Exception{
		logger.info("write post......."+board);
		bservice.write(board,mpRequest);
		return "redirect:list";
	}
	/*글 내용보기를 위한 컨트롤러
	@RequestMapping(value="view",method=RequestMethod.GET)
	public void viewGet(@RequestParam int no,Model model)throws Exception{
		logger.info("view get..............");
		model.addAttribute("view",bservice.view(no));
	}*/
	
	
	@RequestMapping(value="view",method=RequestMethod.GET)
	public String viewGet(BoardVO board,@RequestParam int no,Model model)throws Exception{
		logger.info("view get..............");
		model.addAttribute("view",bservice.view(no));
		
		List<Map<String,Object>> fileList = bservice.filelist(no);
		model.addAttribute("file",fileList);
		
		return "member/view";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*글 수정을 위한 컨트롤러*/
	@RequestMapping(value="change",method=RequestMethod.GET)
	public void changeGet(@RequestParam int no,Model model)throws Exception{
		logger.info("change get........");
		model.addAttribute("change",bservice.view(no));
	}
	@RequestMapping(value="change",method=RequestMethod.POST)
	public String changePost(BoardVO board)throws Exception{
		logger.info("change post............");
		bservice.change(board);
		//return "redirect:view?no="+board.getNo();
		return "redirect:list";
	}
	/*글 삭제를 위한 컨트롤러*/
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deletGet(BoardVO board)throws Exception{
		logger.info("no="+board.getNo());
		bservice.remove(board);
		return "redirect:list";
	}
	/*댓글 쓰기를 위한 컨트롤러*/
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo){
		System.out.println("댓글 쓰기를 위한 컨트롤러");
		ResponseEntity<String> entity = null;
		try {
			rservice.reWrite(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	/*댓글 보기를 위한 컨트롤러*/
	@RequestMapping(value="/all/{no}",method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("no")int no){
		logger.info("ReplyVO : "+no);
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ReplyVO>>(rservice.Replylist(no),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	/*댓글 수정을 위한 컨트롤러*/
	@RequestMapping(value="/{rno}",method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno") int rno,@RequestBody ReplyVO  vo){
		logger.info("ReplyVO : "+rno);
		ResponseEntity<String>entity=null;
		try {
			vo.setRno(rno);
			rservice.reModify(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	/*댓글 삭제를 위한 컨트롤러*/
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno")int rno){
		logger.info("ReplyVO : "+rno);
		ResponseEntity<String> entity = null;
		try {
			rservice.reDel(rno);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
