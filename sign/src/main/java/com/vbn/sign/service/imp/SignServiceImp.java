package com.vbn.sign.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.mapper.ISignMapper;
import com.vbn.sign.model.Sign;
import com.vbn.sign.service.ISignService;

@Service
public class SignServiceImp extends BaseServiceImp<Sign> implements ISignService{

	@Autowired
	ISignMapper signMapper;
}
