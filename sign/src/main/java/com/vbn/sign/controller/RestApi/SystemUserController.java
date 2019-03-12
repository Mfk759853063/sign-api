package com.vbn.sign.controller.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.vbn.sign.common.JSONResult;
import com.vbn.sign.model.SystemUser;
import com.vbn.sign.service.ISystemUserService;

@RestController
@RequestMapping("/sys")

public class SystemUserController {
	
	@Autowired
	ISystemUserService systemUserService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private JSONObject login(@RequestBody SystemUser user) throws Exception {
		try {
			user.setStatus(1);
			SystemUser have = systemUserService.queryOne(user);
			if (user != null) {
				return JSONResult.fillResultString(0, "登录成功", have); 
			}
			return JSONResult.fillResultString(0, "登录失败", null); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(0, "失败", null); 
		}
	}

}
