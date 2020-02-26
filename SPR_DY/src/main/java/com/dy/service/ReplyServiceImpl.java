package com.dy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.mapper.ReplyMapper;
import com.dy.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper rm;
	/*댓글 리스트*/
	@Override
	public List<ReplyVO> Replylist(int no) throws Exception {
		System.out.println("service no = "+no);
		return rm.list(no);
	}
	/*댓글 쓰기*/
	@Override
	public void reWrite(ReplyVO vo) throws Exception {
		rm.reWrite(vo);
	}
	/*댓글 수정*/
	@Override
	public void reModify(ReplyVO vo) throws Exception {
		rm.reModify(vo);
	}
	@Override
	public void reDel(int rno) throws Exception {
		rm.reDel(rno);
	}


}
