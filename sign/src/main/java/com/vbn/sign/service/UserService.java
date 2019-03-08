package com.vbn.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.common.BaseService;
import com.vbn.sign.mapper.IUserMapper;
import com.vbn.sign.model.Sign;

@Service
public class UserService extends BaseService<Sign> {
	
	@Autowired
	IUserMapper userMapper;
	

}
