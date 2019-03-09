package com.vbn.sign.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.mapper.IGroundMapper;
import com.vbn.sign.model.Ground;
import com.vbn.sign.service.IGroundService;

@Service
public class GroundServiceImp extends BaseServiceImp<Ground> implements IGroundService {

	@Autowired
	IGroundMapper groundMapper;
}
