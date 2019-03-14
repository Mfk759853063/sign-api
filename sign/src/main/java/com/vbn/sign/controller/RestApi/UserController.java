package com.vbn.sign.controller.RestApi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.vbn.sign.common.JSONResult;
import com.vbn.sign.model.SystemUser;
import com.vbn.sign.model.User;
import com.vbn.sign.service.ISystemUserService;
import com.vbn.sign.service.IUserService;
import com.vbn.sign.util.DateUtils;
import com.vbn.sign.util.StringUtils;

@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value = "/sync", method = RequestMethod.POST)
	private JSONObject sync(@RequestBody User user) throws Exception {
		try {
			if (user.getId() != null) {
				userService.update(user);
				return JSONResult.fillResultString(0, "更新成功", user);
			} else {
				user.setId(StringUtils.newGUID());
				user.setStatus(1);
				user.setCreateTime(DateUtils.date2TimeStamp(new Date()));
				userService.save(user);
				return JSONResult.fillResultString(0, "同步成功", user);
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return JSONResult.fillResultString(1, "失败", null); 
		}
	}

}
