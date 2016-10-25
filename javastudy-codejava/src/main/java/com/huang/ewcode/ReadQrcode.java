package com.huang.ewcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.ewcode
 * @Description:
 * @date 2016/9/28 18:39
 * @Company: creditease.cn
 */
public class ReadQrcode {

    public static void main(String[] args) throws IOException {

        File file = new File("D:/qrcodenew.png");

        BufferedImage bufferedImage = ImageIO.read(file);
        QRCodeDecoder codeDecoder = new QRCodeDecoder();

        byte[] data = codeDecoder.decode(new MYQRCodeImage(bufferedImage));

        String result = new String(data,"gb2312");

        System.out.println(result);


    }

}
