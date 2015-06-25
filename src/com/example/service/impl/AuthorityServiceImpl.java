package com.example.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Authority;
import com.example.service.AuthorityService;


@Transactional
@Service
public class AuthorityServiceImpl extends BaseServiceImpl<Authority, Integer> implements
		AuthorityService {

	
}
