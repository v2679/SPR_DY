package com.dy.mapper;

import java.util.List;
import java.util.Map;

import com.dy.model.BoardVO;
import com.dy.model.Criteria;

public interface BoardMapper {
	
	//전체 목록 리스트
	public List<BoardVO> listList() throws Exception;
	
	//전체 목록 리스트(페이징)
	public List<BoardVO> boardList(Criteria cri) throws Exception;
	
	//board테이블의 전체 갯수
	public int boardCount(Criteria cri) throws Exception;
	
	//게시판 글 쓰기
	public void write(BoardVO board)throws Exception; 
	
	//게시판 글 내용보기
	public BoardVO view(int no) throws Exception;
	
	//게시판 글 수정
	public void change(BoardVO board)throws Exception;
	
	//게시판 글 삭제
	public void remove(BoardVO board)throws Exception;
	
	//첨부파일 업로드
	public void insertFile(Map<String,Object>map)throws Exception;
	
	//첨부파일 조회
	public List<Map<String,Object>> filelist(int no)throws Exception; 
}
