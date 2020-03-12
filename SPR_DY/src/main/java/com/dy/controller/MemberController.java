package com.dy.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.model.LoginVO;
import com.dy.model.MemberVO;
import com.dy.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService mservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	/*홈페이지 이동을 위한 controller*/
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String homeGet()throws Exception{
		logger.info("home get..........");
		return "member/home";
	}
	
	//아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/ovcheck",method=RequestMethod.POST)
	public int ovcheck(MemberVO member)throws Exception{
		int result = mservice.ovcheck(member);
		return result;
	}
	
	/*회원가입을 위한 controller*/
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String joinGet()throws Exception{
		logger.info("join get.....");
		return "member/join";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String joinPost(MemberVO member)throws Exception{
		logger.info("join post......."+member);
		int result = mservice.ovcheck(member);
		try {
			if(result == 1) {
				return "member/join";
			}else if(result==0) {
				mservice.join(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:login";
	}
	/*회원탈퇴를 위한 controller*/
	@RequestMapping(value="/out",method=RequestMethod.GET)
	public String outGet(MemberVO member)throws Exception{
		logger.info("out get..............");
		return "member/out";
	}
	@RequestMapping(value="/out",method=RequestMethod.POST)
	public String outPost(MemberVO member)throws Exception{
		logger.info("id="+member.getId());
		logger.info("pw="+member.getPw());
		mservice.out(member);
		return "redirect:home";
	}
	/*로그인을 위한 controller*/
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void loginGet(LoginVO login) {
		logger.info("login get.............");
		
	}
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public void loginPost(LoginVO login,Model model)throws Exception{
		MemberVO member=mservice.login(login);
		System.out.println(member);
		if(member==null) {return;}
		model.addAttribute("memberVO",member);
		logger.info("login post.............");
	}
		
	
	
	/*로그아웃을 위한 controller*/
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:home";
	}
}
