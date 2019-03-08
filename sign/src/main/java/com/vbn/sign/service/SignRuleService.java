package com.vbn.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbn.sign.common.BaseService;
import com.vbn.sign.mapper.ISignRuleMapper;
import com.vbn.sign.model.SignRule;


@Service
public class SignRuleService extends BaseService<SignRule>{

	@Autowired
	ISignRuleMapper signRuleMapper;
}
