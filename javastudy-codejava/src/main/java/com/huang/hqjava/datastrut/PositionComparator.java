package com.huang.hqjava.datastrut;

import java.util.Comparator;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.datastrut
 * @Description:
 * @date 2016/4/13 20:14
 * @Company: creditease.cn
 */
public class PositionComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getPosition().compareTo(o2.getPosition());
    }
}
