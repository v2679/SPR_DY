package com.dy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dy.mapper.MemberMapper;
import com.dy.model.LoginVO;
import com.dy.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberMapper mm;
	//회원가입
	@Override
	public void join(MemberVO member) throws Exception {
		mm.join(member);
	}
	//회원탈퇴
	@Override
	public void out(MemberVO member) throws Exception {
		mm.out(member);
	}
	//로그인
	@Override
	public MemberVO login(LoginVO login) throws Exception {
		return mm.login(login);
	}
	//아이디 중복체크
	@Override
	public int ovcheck(MemberVO member) throws Exception {
		return mm.ovcheck(member);
	}
	
}
