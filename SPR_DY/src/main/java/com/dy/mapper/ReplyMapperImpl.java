package com.dy.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dy.model.ReplyVO;

@Repository
public class ReplyMapperImpl implements ReplyMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.dy.mapper.ReplyMapper";
	
	/*댓글쓰기*/
	@Override
	public void reWrite(ReplyVO vo) throws Exception {
		sqlSession.insert(namespace+".reWrite",vo);
	}
	/*댓글 리스트*/
	@Override
	public List<ReplyVO> list(int no) throws Exception {
		System.out.println("mapper no = "+no);
		List list=sqlSession.selectList(namespace+".replyList",no);
		return list;
	}
	//댓글 수정
	public void reModify(ReplyVO vo)throws Exception{
		sqlSession.update(namespace+".reModify",vo);
	}
	@Override
	public void reDel(int rno) throws Exception {
		sqlSession.delete(namespace+".reDel",rno);
	}

}
