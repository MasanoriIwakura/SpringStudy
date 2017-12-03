package com.example.springstudy.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.springstudy.Entities.User;
import com.example.springstudy.service.UsersService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class LoginController {
	
	private static final String VIEW = "login";
	private static final String HOME = "home";
	
	@Autowired
	public UsersService service;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "login";
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView userList(ModelAndView mov, 
			@RequestParam("userId") String userId,
			@RequestParam("password") String password) {

		User user = service.search(userId);
		
		if (user != null && user.password.equals(password)) {
			// ログイン成功
			mov.setViewName(HOME);
			mov.addObject("usr", user);
		} else {
			// ログイン失敗
			mov.setViewName(VIEW);
			mov.addObject("msg", "ユーザーまたはパスワードが一致しません。");
		}
		
		return mov;
	}
}
