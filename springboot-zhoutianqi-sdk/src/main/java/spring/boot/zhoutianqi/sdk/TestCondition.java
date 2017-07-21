package spring.boot.zhoutianqi.sdk;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.testcondition")
public class TestCondition {
	/**
	* @author zhoutianqi
	* @className TestCondition.java
	* @date 2017年7月3日 上午10:31:11
	* @description 
	*/
	private String str = "zhoutianqi";

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}
