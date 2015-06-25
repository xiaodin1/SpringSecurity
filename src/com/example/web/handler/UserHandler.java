package com.example.web.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.Page;

@RequestMapping("/user")
@Controller
public class UserHandler {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(@RequestParam(required=false,defaultValue="1") Integer pageNum, Map<String, Object> map) {
		Page<User> page = userService.getPage(pageNum, 5);
		map.put("page", page);
		
		return "user/list";
	}
	
	
	
	
}
