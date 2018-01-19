package com.huang.hqjava.staticlass;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang
 * @Description:
 * @date 2016/2/1 17:08
 * @Company: a
 */
public class Person {

    private String name;
    private Home home;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    //静态内部类
    public static class Home {

        private String address;
        private String tel;

        public Home(String address, String tel) {
            this.address = address;
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }

    /**
     * 覆写equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) { //推荐使用getClass方法判断
            Person p = (Person)obj;
            if (p.getName() == null || name == null) {
                return  false;
            } else {
                return name.equalsIgnoreCase(p.getName());
            }
        }
        return false;
    }

    /**
     * 覆写equals方法时需要同时覆写hashCode方法 使用HashCodeBuilder Commons工具类
     * @return
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).toHashCode();
    }

    /**
     * 推荐覆写toString方法
     * @return
     */
    @Override
    public String toString() {
       // return String.format("%s.name=%s",this.getClass(),name);
        return new ToStringBuilder(this).append("姓名",name).toString();//使用Commons工具类
    }
}
