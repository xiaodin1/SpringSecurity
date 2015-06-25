package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;

/**
 * user用户相关接口的具体实现类
 * 所有需要使用的通用方法需要重写使用userDao调用才可
 * 特殊方法需另定义
 * @author anonymous
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements
		UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}
	
}
