package com.lkp.util;

/**
 *
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 图片压缩处理
 * @author 崔素强
 */
public class ImgCompressUtil {
    private Image img;
    private int width;
    private int height;

    public boolean Compress(String url,String newurl){
        try {
            File file = new File(url);
//            if (file.exists() && file.isFile()){
            ImgCompressUtil imgCom = new ImgCompressUtil(url);
            int length = (int)Math.ceil (file.length()/1024);

            if(length<100){
                FileChannel inputChannel = null;
                FileChannel outputChannel = null;
                FileInputStream  inputStream= new FileInputStream(file);
                inputChannel = inputStream.getChannel();
                FileOutputStream outputStream = new FileOutputStream(new File(newurl));
                outputChannel = outputStream.getChannel();
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
                inputChannel.close();
                outputChannel.close();
                inputChannel.close();
                outputChannel.close();

            }else{
                BufferedImage bufferedImage = ImageIO.read(file);
                int val = (int)Math.sqrt(length/100);
                imgCom.resizeFix(bufferedImage.getWidth()/val, bufferedImage.getHeight()/val,newurl);
            }
            return true;

//            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 构造函数
     */
    public ImgCompressUtil(String fileName){
        File file = new File(fileName);// 读入文件

        try {
            img = ImageIO.read(file);      // 构造Image对象
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = img.getWidth(null);    // 得到源图宽
        height = img.getHeight(null);  // 得到源图长
    }
    /**
     * 按照宽度还是高度进行压缩
     * @param w int 最大宽度
     * @param h int 最大高度
     */
    public void resizeFix(int w, int h,String newurl) throws IOException {
        if (width / height > w / h) {
            resizeByWidth(w,newurl);
        } else {
            resizeByHeight(h,newurl);
        }
    }
    /**
     * 以宽度为基准，等比例放缩图片
     * @param w int 新宽度
     */
    public void resizeByWidth(int w,String newurl) throws IOException {
        int h = (int) (height * w / width);
        resize(w, h,newurl);
    }
    /**
     * 以高度为基准，等比例缩放图片
     * @param h int 新高度
     */
    public void resizeByHeight(int h,String newurl) throws IOException {
        int w = (int) (width * h / height);
        resize(w, h,newurl);
    }
    /**
     * 强制压缩/放大图片到固定的大小
     * @param w int 新宽度
     * @param h int 新高度
     */
    public void resize(int w, int h,String newurl) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        /*
        File destFile = new File(newurl);
        FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
        // 可以正常实现bmp、png、gif转jpg
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image); // JPEG编码
        out.close();*/

 /*       String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);*/
        //FileOutputStream out = new FileOutputStream(dstName);
        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        //encoder.encode(dstImage);
        ImageIO.write(image, /*"GIF"*/ "jpg" /* format desired */ , new File(newurl) /* target */ );
    }
}
