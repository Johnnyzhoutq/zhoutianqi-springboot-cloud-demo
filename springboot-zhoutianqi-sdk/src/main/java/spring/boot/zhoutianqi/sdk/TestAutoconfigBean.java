package spring.boot.zhoutianqi.sdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({ TestCondition.class})
@EnableConfigurationProperties(TestCondition.class)
public class TestAutoconfigBean {
	/**
	* @author zhoutianqi
	* @className TestAutoconfigBean.java
	* @date 2017年7月3日 上午10:26:31
	* @description 
	*/
	@Autowired
	private TestCondition condition;
	@Bean
	public TestBean getBean(TestCondition condition){
		TestBean bean = new TestBean();
		bean.setName(condition.getStr());
		return bean;
	}
}
