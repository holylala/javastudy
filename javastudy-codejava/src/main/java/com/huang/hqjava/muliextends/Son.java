package com.huang.hqjava.muliextends;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.muliextends
 * @Description:
 * @date 2016/3/22 18:04
 * @Company: a
 */
public class Son extends FatherImpl implements Mother {

    @Override
    public int strong() {
        return super.strong() + 1;
    }

    @Override
    public int kind() {
        return new MotherSecial().kind();
    }

    //使用成员内部类 实现多继承
    private class MotherSecial extends MotherImpl {
        @Override
        public int kind() {
            return super.kind() - 1;
        }
    }

}
