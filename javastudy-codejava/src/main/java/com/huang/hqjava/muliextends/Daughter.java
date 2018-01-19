package com.huang.hqjava.muliextends;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.muliextends
 * @Description:
 * @date 2016/3/22 18:09
 * @Company: a
 */
public class Daughter extends MotherImpl implements Father {
    @Override
    public int strong() {
        return new FatherImpl() { //匿名内部类
            @Override
            public int strong() {
                return super.strong() - 2;
            }
        }.strong();
    }
}
