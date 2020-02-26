package com.dy.service;

import java.util.List;

import com.dy.model.ReplyVO;

public interface ReplyService {
	//댓글 조회
	public List<ReplyVO> Replylist(int no)throws Exception;
	//댓글 쓰기
	public void reWrite(ReplyVO vo)throws Exception;
	//댓글 수정
	public void reModify(ReplyVO vo)throws Exception;
	//댓글 삭제
	public void reDel(int rno)throws Exception;
}
