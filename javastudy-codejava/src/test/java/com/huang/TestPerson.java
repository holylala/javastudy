package com.huang;

import com.huang.hqjava.staticlass.Person;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang
 * @Description:
 * @date 2016/2/1 17:14
 * @Company: creditease.cn
 */
public class TestPerson {

    public void testPerson() {

        Person p = new Person("p1");
        p.setHome(new Person.Home("address infos","18644958393"));

    }
}
