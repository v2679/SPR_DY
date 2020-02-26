package com.dy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dy.model.BoardVO;
import com.dy.model.Criteria;

@Repository
public class BoardMapperImpl implements BoardMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.dy.mapper.BoardMapper";
	
	//전체 목록 리스트
	@Override
	public List<BoardVO> listList() throws Exception {
		List list=sqlSession.selectList(namespace+".listList");
		System.out.println("list="+list);
		return list;
	}
	//전체 목록 리스트(페이징)
	@Override
	public List<BoardVO> boardList(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".boardList",cri);
		return list;
	}
	//board테이블의 전체 갯수
	@Override
	public int boardCount(Criteria cri) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".boardCount",cri);
		return cnt;
	}
	//게시판 글쓰기
	@Override
	public void write(BoardVO board) throws Exception {
		System.out.println("board="+board);
		sqlSession.insert(namespace+".write",board);
	}
	//게시판 글 내용보기
	@Override
	public BoardVO view(int no) throws Exception {
		BoardVO boardvo=sqlSession.selectOne(namespace+".view",no);
		return boardvo;
	}
	//글 내용 수정
	@Override
	public void change(BoardVO board) throws Exception {
		sqlSession.update(namespace+".change",board);
	}
	//글 삭제
	@Override
	public void remove(BoardVO board) throws Exception {
		sqlSession.delete(namespace+".remove",board);
	}
	//첨부파일 업로드
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		
		System.out.println(map);
		
		sqlSession.insert(namespace+".file",map);
	}
	//첨부파일 죄회
	@Override
	public List<Map<String,Object>> filelist(int no) throws Exception{
		return sqlSession.selectList(namespace+".filelist",no);
	}
}
