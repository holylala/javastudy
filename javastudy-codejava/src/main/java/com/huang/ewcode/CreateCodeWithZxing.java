package com.huang.ewcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.ewcode
 * @Description: 使用zxing生成二维码
 * @date 2016/9/28 12:37
 * @Company: creditease.cn
 */
public class CreateCodeWithZxing {

    public static void main(String[] args) {

        int width = 300;
        int height = 300;
        String format = "png";
        String content = "http://www.imooc.com";

        //定义二维码参数
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        //容错级别
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);//留白

        //生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path file = new File("D:/qrcode.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format, file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
