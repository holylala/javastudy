package com.digitsign;

import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.digitsign
 * @Description: 数字签名 RSA算法
 * @date 2016/7/26 22:56
 * @Company: a
 */
public class RSATest {

    private static String src = "huang rsa";
    //psvm  soutv
    public static void main(String[] args) {
        jdkRSA();
    }

    public static void jdkRSA() {

        try {

            //1.初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);//key长度

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();

            //2.执行签名
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());//私钥签名

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(privateKey);
            signature.update((src+"aa=222;cc=111").getBytes());

            byte[] result = signature.sign();
            System.out.println("生成Jdk rsa 签名:" + Hex.encodeHexString(result));

            //3.验证签名
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());//使用公钥验证签名
            keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(publicKey);
            signature.update((src+"aa=222;cc=111").getBytes());
            boolean bool = signature.verify(result);
            System.out.println("jdk rsa 签名验证 是否正确 = " + bool);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
