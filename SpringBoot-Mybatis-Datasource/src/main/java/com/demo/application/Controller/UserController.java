package com.demo.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.application.entity.SysUser;
import com.demo.application.service.UserService;
/**  
* @Title：UserController.java
* @Author:zhoutianqi
* @Description:控制层
* @Date：2017年5月24日下午5:47:02  
*/
@RestController
public class UserController {
	@Autowired
	private  UserService userService;
	@RequestMapping(value="/master")
    public String logout(){
		SysUser user = new SysUser("master","master","master");
		userService.addUserByMaster(user);
		return "ok";
    }
	@RequestMapping(value="/slaver")
    public String slaver(){
		SysUser user = new SysUser("slaver","slaver","slaver");
		userService.addUserBySlaver(user);
		return "ok";
    }
}
