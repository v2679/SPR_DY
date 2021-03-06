package com.dy.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dy.model.BoardVO;
import com.dy.model.Criteria;

public interface BoardService {
	
	//게시판 리스트
	public List<BoardVO> listList()throws Exception;
	
	//게시판 리스트(페이징)
	public List<BoardVO> boardList(Criteria cri) throws Exception;
	
	//board테이블의 전체 갯수 파악
	public int boardCount(Criteria cri) throws Exception;
	
	//게시판 글쓰기
	public void write(BoardVO board, MultipartHttpServletRequest mpRequest)throws Exception;
	
	//게시판 글 내용보기
	public BoardVO view(int no)throws Exception;
	
	//게시판 글 수정
	public void change(BoardVO board)throws Exception;
	
	//게시판 글 삭제
	public void remove(BoardVO board)throws Exception;
	
	
	//첨부파일 조회
	public List<Map<String, Object>> filelist(int no)throws Exception;
	
	//첨부파일 다운
	public Map<String,Object> fileinfo(Map<String,Object>map)throws Exception;
}
