package com.demo.application.service;

import com.demo.application.entity.SysUser;

public interface UserService {
	public void addUserByMaster(SysUser user);
	public void addUserBySlaver(SysUser user);
}
