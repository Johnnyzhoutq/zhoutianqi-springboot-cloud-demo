package com.demo.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.application.entity.SysUser;
import com.demo.application.mastermapper.MUserMapper;
import com.demo.application.service.UserService;
import com.demo.application.slavermapper.SUserMapper;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private MUserMapper muserMapper;
	@Autowired
	private SUserMapper suserMapper;
	@Override
	public void addUserByMaster(SysUser user) {
		muserMapper.addUser(user);
		
	}
	@Override
	public void addUserBySlaver(SysUser user) {
		suserMapper.addUser(user);
		
	}
	
	

}
