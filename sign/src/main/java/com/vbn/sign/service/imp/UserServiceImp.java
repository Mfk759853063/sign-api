package com.vbn.sign.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.mapper.IUserMapper;
import com.vbn.sign.model.User;
import com.vbn.sign.service.IUserService;


@Service
public class UserServiceImp extends BaseServiceImp<User> implements IUserService {

	
	@Autowired
	IUserMapper userMapper;
}
