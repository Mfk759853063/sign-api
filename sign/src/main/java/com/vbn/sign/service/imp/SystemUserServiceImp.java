package com.vbn.sign.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.mapper.ISystemUserMapper;
import com.vbn.sign.model.SystemUser;
import com.vbn.sign.service.ISystemUserService;

@Service
public class SystemUserServiceImp extends BaseServiceImp<SystemUser> implements ISystemUserService{

	
	@Autowired
	ISystemUserMapper systemUserMapper;
}
