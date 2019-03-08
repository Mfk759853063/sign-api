package com.vbn.sign.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vbn.sign.common.MyMapper;
import com.vbn.sign.model.SignRule;
import com.vbn.sign.model.User;

@Mapper
public interface IUserMapper extends MyMapper<User> {

}
