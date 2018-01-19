package com.digitsign;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.digitsign
 * @Description:
 * @date 2016/8/21 22:56
 * @Company: a
 */
public class Base64Test {

    private static String src = "huang love you! >> *&";

    public static void main(String[] args) {
        jdkBase64();
    }

    public static void jdkBase64() {

        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(src.getBytes());
        System.out.println("Encode:>>>"+encode);

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            System.out.println("decode:>>>" + new String(decoder.decodeBuffer(encode)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
