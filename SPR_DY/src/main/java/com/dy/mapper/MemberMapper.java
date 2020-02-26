package com.dy.mapper;

import com.dy.model.LoginVO;
import com.dy.model.MemberVO;

public interface MemberMapper {
	//회원가입
	public void join(MemberVO member) throws Exception;
	//회원탈퇴
	public void out(MemberVO member) throws Exception;
	//로그인
	public MemberVO login(LoginVO login) throws Exception;
	//아이디 중복체크
	public int ovcheck(MemberVO member)throws Exception;
}
