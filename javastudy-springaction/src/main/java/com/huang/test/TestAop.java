/**
 * 
 */
package com.huang.test;

import com.huang.aop.MindReader;
import com.huang.aop.Player;
import com.huang.aop.Thinker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


/**   
 * @Title: TestBean.java 
 * @Package com.huang.test 
 * @Description: 
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-4 下午03:51:53 
 * @version V1.0   
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAop extends UnitTestBase {
	
	public TestAop() {
		super("classpath*:spring-aop.xml");
		//super("com/huang/resource/spring-ioc.xml");
	}
	
	@Test
	public void test1() {
		
		Player player = super.getBean("player");
		player.play();
	}
	
	@Test
	public void test2() {
		
		Thinker girl = super.getBean("girl");
		girl.thinkSometing("晚上我想去看电影....");
		
//		MindReader getminder = super.getBean("getminder");
//		System.out.println(getminder.getMindInfos());
	}
	
}
