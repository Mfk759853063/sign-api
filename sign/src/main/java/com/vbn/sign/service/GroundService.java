package com.vbn.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.common.BaseService;
import com.vbn.sign.mapper.IGroundMapper;
import com.vbn.sign.model.Ground;

@Service
public class GroundService extends BaseService<Ground>{

	
	@Autowired
	IGroundMapper groundMapper;
	
}
