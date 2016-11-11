package com.imooc.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description:
 * @date 2016/11/11 14:22
 * @Company: creditease.cn
 */
public class ReflectUtils {

    //获得一个泛型类的实际泛型类型 (获得超类的泛型参数的实际类型)
    public static <T> Class<T> getGenricClassType(Class clz) {
        //getClass().getGenericSuperclass()
        // 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        Type type = clz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] types = pt.getActualTypeArguments();
            if (types.length > 0 && types[0] instanceof Class) {
                return (Class) types[0];
            }
        }
        return  (Class)Object.class;//没有extends 父类直接是Object
    }


}
