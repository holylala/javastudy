package com.huang.ewcode;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.ewcode
 * @Description:
 * @date 2016/9/28 16:49
 * @Company: creditease.cn
 */
public class ReadQrcodeWithZxing {

    public static void main(String[] args) {
        MultiFormatReader formatReader = new MultiFormatReader();
        File file = new File("D:/qrcode.png");
        try {

            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

            //定义二维码参数
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");

            Result result = formatReader.decode(binaryBitmap,hints);

//            解析结果:>>http://www.imooc.com
//            格式类型:>>QR_CODE
//            文本内容:>>http://www.imooc.com

            System.out.println("解析结果:>>"+result.toString());
            System.out.println("格式类型:>>"+result.getBarcodeFormat());
            System.out.println("文本内容:>>"+result.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
