package com.dy.mapper;

import java.util.List;

import com.dy.model.ReplyVO;

public interface ReplyMapper {
	
	//댓글 조회
	public List<ReplyVO> list(int no)throws Exception;
	//댓글 쓰기
	public void reWrite(ReplyVO vo)throws Exception;
	//댓글 수정
	public void reModify(ReplyVO vo)throws Exception;
	//댓글 삭제
	public void reDel(int rno)throws Exception;
}
