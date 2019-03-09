package com.vbn.sign.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.mapper.ISignMapper;
import com.vbn.sign.model.SignRule;
import com.vbn.sign.service.ISignRuleService;

@Service
public class SignRuleServiceImp extends BaseServiceImp<SignRule> implements ISignRuleService {

	@Autowired
	ISignMapper signMapper;
}
