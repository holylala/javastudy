package com.huang.ewcode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.ewcode
 * @Description:
 * @date 2016/9/28 18:10
 * @Company: creditease.cn
 */
public class CreateQrcode {

    public static void main(String[] args) throws IOException {

        String qrData = "http://www.baidu.com";
        //QRcode生成二维码:宽度和高度的公式为：67+12*（版本号-1）
        int width = 67 + 12 * (7 -1);
        int height = 67 + 12 * (7 -1);

        Qrcode x = new Qrcode();
        x.setQrcodeErrorCorrect('M');
        x.setQrcodeEncodeMode('B');//N代表数字 A代表a-Z B代表其他字符
        x.setQrcodeVersion(7);

        byte[] d = new byte[0];
        try {
            d = qrData.getBytes("gb2312"); //有汉字时
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D gs = bufferedImage.createGraphics();

        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0,0,width,height);

        int pixoff = 2;//偏移量

        if (d.length > 0 && d.length < 120) {
            boolean[][] s = x.calQrcode(d);
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        gs.fillRect(j*3+pixoff,i*3+pixoff,3,3);
                    }
                }
            }
        }

        gs.dispose();
        bufferedImage.flush();

        ImageIO.write(bufferedImage,"png", new File("D:/qrcodenew.png"));

    }
}
