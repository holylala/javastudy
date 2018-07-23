/**
 * 
 */
package com.huang.autoiocmore;

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

@Component("zooker")
public class Zooker {
	
	//required = false 表示配置自动装配是可选的 如果没有匹配的bean也不会报错
	//driver1 是对应的Driver类用 @Component("driver1")注解配置
	//当配置了<context:include-filter type="assignable" expression="com.huang.autoiocmore.Animal" />
	//之后 从animal实现的类 都可以不用加 @Component 注解  按照无限定名 @Qualifier("bird") 配置一下即可
	@Autowired(required = false)
	@Qualifier("tiger")
	private Animal animal;

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public String action() {
		return animal.speak()+",在休息";
	}
	
}
