package com.huang.hqjava.datastrut;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.datastrut
 * @Description:
 * @date 2016/4/13 19:51
 * @Company: creditease.cn
 */
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private Position position;

    public Employee(int _id, String _name, Position _position) {
        id = _id;
        name = _name;
        position = _position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //使用工具类,按照id排序 默认升序
    @Override
    public int compareTo(Employee o) {
        //return new CompareToBuilder().append(id,o.id).toComparison();
        //先职位排序 再工号排序
        return  new  CompareToBuilder().append(position,o.position).append(id,o.id).toComparison();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>(5);

        list.add(new Employee(1009,"fff",Position.Staff));
        list.add(new Employee(1001,"aaa",Position.Boss));
        list.add(new Employee(1007,"bbb",Position.Manager));
        list.add(new Employee(1011,"ccc",Position.Manager));
        list.add(new Employee(1006,"fff",Position.Staff));
        list.add(new Employee(1003,"ccc",Position.Manager));
        list.add(new Employee(1004,"gggg",Position.Staff));

        //使用Employee默认的排序方法
        Collections.sort(list);

        //使用指定的排序方法
        //Collections.sort(list,new PositionComparator());
        //倒序排序
       // Collections.reverse(list);

        //or: 一个方法
       // Collections.sort(list,Collections.reverseOrder(new PositionComparator()));

        for(Employee e : list) {
            System.out.println(e);
        }
    }

}


enum  Position {
    Boss,Manager,Staff;
}