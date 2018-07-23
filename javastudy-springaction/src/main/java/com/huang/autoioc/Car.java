/**
 * 
 */
package com.huang.autoioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**   
 * @Title: Car.java 
 * @Package com.huang.autoioc 
 * @Description: 
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-9 上午11:28:17 
 * @version V1.0   
 */

@Component("car")
public class Car {
	
	//required = false 表示配置自动装配是可选的 如果没有匹配的bean也不会报错
	//driver1 是对应的Driver类用 @Component("driver1")注解配置 有了该注解 @Qualifier("driver1") 则xml中关于bean id的定义失效
	@Autowired(required = false)
	@Qualifier("driver1")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String drive() {
		return person.speak()+",在开车";
	}
	
}
