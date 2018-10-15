package com.jd.springboot.demo.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.util.Hashtable;

/**
 * wangzhen23
 * 2018/10/9.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String text = "测试二维码 I Love You！"; // 二维码内容
        int width = 270; // 二维码图片宽度
        int height = 270; // 二维码图片高度
        String format = "gif";// 二维码的图片格式
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");    // 内容所使用字符集编码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);// 生成二维码
        File outputFile = new File("d:" + File.separator + "new.gif");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
    }
}
