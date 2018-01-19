package com.huang.ewcode;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.ewcode
 * @Description:
 * @date 2016/9/28 18:44
 * @Company: a
 */
public class MYQRCodeImage implements QRCodeImage {

    BufferedImage bufferedImage;

    public MYQRCodeImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    @Override
    public int getPixel(int i, int i1) {
        return bufferedImage.getRGB(i,i1);
    }
}
