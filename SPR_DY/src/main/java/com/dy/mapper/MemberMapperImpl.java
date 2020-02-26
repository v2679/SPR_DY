package com.dy.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dy.model.LoginVO;
import com.dy.model.MemberVO;

@Repository
public class MemberMapperImpl implements MemberMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.dy.mapper.MemberMapper";
	
	//회원가입
	@Override
	public void join(MemberVO member) throws Exception{
		sqlSession.insert(namespace+".join",member);
	}
	//회원탈퇴
	@Override
	public void out(MemberVO member) throws Exception {
		sqlSession.delete(namespace+".out",member);
	}
	//로그인
	@Override
	public MemberVO login(LoginVO login) throws Exception {
		MemberVO member=sqlSession.selectOne(namespace+".login",login);
		return member;
	}
	//아이디 중복 체크
	@Override
	public int ovcheck(MemberVO member) throws Exception {
		int result = sqlSession.selectOne(namespace+".ovcheck",member);
		return result;
	}

}
