package com.huang.hqjava.objectclone;

import java.io.Serializable;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.objectclone
 * @Description:
 * @date 2016/3/22 18:20
 * @Company: creditease.cn
 */
public class Person implements Cloneable,Serializable {

    private static final long serialVersionUID = -4488135706479721036L;

    private String name;

    private Person father;

    public Person(String _name) {
        name = _name;
    }

    public Person(String _name,Person _parent) {
        name = _name;
        father = _parent;
    }

    public Person clone() {
        Person p = null;
        try {
            p = (Person) super.clone(); //这种方式实现的是浅拷贝 对象类型只拷贝引用
            p.setFather(new Person(p.getFather().getName())); //深拷贝
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }
}
