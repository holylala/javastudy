package com.digitsign;

import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.digitsign
 * @Description:
 * @date 2016/7/27 23:02
 * @Company: a
 */
public class DSATest {

    private static String src = "huang dsa";

    public static void main(String[] args) {
        jdkDSA();
    }

    public static void jdkDSA() {

        try {
            //1.初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
            keyPairGenerator.initialize(512);//key长度

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            DSAPublicKey dsaPublicKey = (DSAPublicKey)keyPair.getPublic();
            DSAPrivateKey dsaPrivateKey = (DSAPrivateKey)keyPair.getPrivate();

            //2.执行签名
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(dsaPrivateKey.getEncoded());//私钥签名
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

            Signature signature = Signature.getInstance("SHA1withDSA");
            signature.initSign(privateKey);
            signature.update((src+"aa=222;cc=111").getBytes());

            byte[] result = signature.sign();
            System.out.println("生成Jdk dsa 签名:" + Hex.encodeHexString(result));


            //3.验证签名
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dsaPublicKey.getEncoded());//使用公钥验证签名
            keyFactory = KeyFactory.getInstance("DSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            signature = Signature.getInstance("SHA1withDSA");
            signature.initVerify(publicKey);
            signature.update((src+"aa=222;cc=111").getBytes());
            boolean bool = signature.verify(result);
            System.out.println("jdk dsa 签名验证 是否正确 = " + bool);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
