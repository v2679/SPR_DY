package com.dy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dy.model.BoardVO;

@Controller
@RequestMapping("/member")
public class InformationController {
	
	private static final Logger logger = LoggerFactory.getLogger(InformationController.class);
	
	@RequestMapping(value="/husky",method=RequestMethod.GET)
	public String huskyGet()throws Exception{
		logger.info("husky get.................");
		return "member/husky";
	}
	
	
}
