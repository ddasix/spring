package com.multicampus.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

@Controller
public class AuthController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO userVo){
		userVo.setId("test");
		userVo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO userVo, HttpSession session) {
		System.out.println("로그인 기능 처리"+userService.getUser(userVo).toString());
		UserVO user = userService.getUser(userVo);
		
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			userVo.setId("test");
			userVo.setPassword("test");
			return "login.jsp";
		}
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "index.jsp";
	}
}