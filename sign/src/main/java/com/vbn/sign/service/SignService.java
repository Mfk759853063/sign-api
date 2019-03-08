package com.vbn.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.common.BaseService;
import com.vbn.sign.mapper.ISignMapper;
import com.vbn.sign.model.Sign;


@Service
public class SignService extends BaseService<Sign> {
	
	@Autowired
	ISignMapper signMapper;
	

}
