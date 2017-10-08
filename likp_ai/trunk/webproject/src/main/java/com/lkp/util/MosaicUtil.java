package com.lkp.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 */
public class MosaicUtil {
    public static File createMosaicPic(File templet,File target,String filePath,int startX,int startY,int endX,int endY,String nickname,double scale1,double transX,double transY){
        try {
            File result = new File(filePath);
            int width=Math.abs(endX-startX);
            int height=Math.abs(endY-startY);
            Image templetImg = ImageIO.read(templet);//模板图片
            Image targetImg = ImageIO.read(target);
            int width1 = templetImg.getWidth(null);//模板图片的宽度
            int height1 = templetImg.getHeight(null);
            //     创建图片缓存  先绘制模板图片
            BufferedImage bufferedImage1 = new BufferedImage(width1,height1,BufferedImage.TYPE_INT_RGB);
            Graphics g = bufferedImage1.createGraphics();
            g.drawImage(templetImg,0,0,width1,height1,null);
            Metadata metadata = ImageMetadataReader.readMetadata(target);
            int angel = 0;
            for(Directory directory : metadata.getDirectories()){
                if(directory.containsTag(ExifDirectoryBase.TAG_ORIENTATION)){
                    switch (directory.getInt(ExifDirectoryBase.TAG_ORIENTATION)){
                        case 3:angel=180;break;
                        case 6:angel=90;break;
                        case 8:angel=270;break;
                    }
                }
            }
            if(angel!=0){
                int width2 = targetImg.getWidth(null);//原图的宽度
                int height2 = targetImg.getHeight(null);
                System.out.println(angel);
                Rectangle rect_des = MosaicUtil.CalcRotatedSize(new Rectangle(width2,height2),angel);
                BufferedImage bufferedImage2 = new BufferedImage(rect_des.width, rect_des.height,BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = bufferedImage2.createGraphics();
                graphics2D.translate((rect_des.width - width2) / 2,
                        (rect_des.height - height2) / 2);
                graphics2D.rotate(Math.toRadians(angel), width2 / 2, height2 / 2);

                graphics2D.drawImage(targetImg, null, null);
                graphics2D.dispose();
                targetImg.flush();
                targetImg=bufferedImage2;
            }
            //原图的长宽
            double width2 = targetImg.getWidth(null);
            double height2 = targetImg.getHeight(null);
            //原图和模板图片填充部分的长宽比例
            double scale = (double)width/(double)height;
            double scale2 = (double)width2/(double)height2;

//            //原图的"宽高比"比填充部分更大   原图相对较宽
//            if(scale2>scale){
////                    int adjustWidth=width;
////                    double ratio=(double)width/(double)width2;
////                    int adjustHeight=(int)(ratio*height2);
//                int adjustHeight=height;
//                double ratio=(double)height/(double)height2;
//                int adjustWidth=(int)(width2*ratio);
//                    g.drawImage(targetImg,startX,startY+((height-adjustHeight)/2),adjustWidth,adjustHeight,null);
//                if(nickname!=null){
//                    g.setFont(new Font("微软雅黑", Font.LAYOUT_LEFT_TO_RIGHT, width1/40));// 写入签名
//                    g.setColor(new Color(180,180,180));
//                    FontMetrics metrics;
//                    metrics = g.getFontMetrics(g.getFont());
//                    int textH = metrics.getHeight(); //字符串的高, 只和字体有关
//                    int textW; //字符串的宽
//                    textW = metrics.stringWidth(nickname);
//                    g.drawString(nickname, endX-(width-adjustWidth)/2-textW,endY-(height-adjustHeight)/2+textH);
//                }
//            }
//            //若图片太窄
//            else{
////                    double ratio=(double)height/(double)height2;
////                    int adjustHeight=height;
////                    int adjustWidth=(int)(width2*ratio);
//                double ratio=(double)width/(double)width2;
//                int adjustWidth=width;
//                int adjustHeight=(int)(height2*ratio);
//                    g.drawImage(targetImg,startX+((width-adjustWidth)/2),startY,adjustWidth,adjustHeight,null);
//                if(nickname!=null){
//                    g.setFont(new Font("微软雅黑", Font.LAYOUT_LEFT_TO_RIGHT, width1/40));// 写入签名
//                    g.setColor(new Color(180,180,180));
//                    FontMetrics metrics;
//                    metrics = g.getFontMetrics(g.getFont());
//                    int textH = metrics.getHeight(); //字符串的高, 只和字体有关
//                    int textW; //字符串的宽
//                    textW = metrics.stringWidth(nickname);
//                    g.drawString(nickname, endX-(width-adjustWidth)/2-textW,endY-(height-adjustHeight)/2+textH);
//                }
//            }

            Image img;
            ImageFilter cropFilter;
            int swidth=(int)(width2*scale1);//目标图片缩放后的宽度
            int sheight=(int)(height2*scale1);
            Image image = targetImg.getScaledInstance(swidth, sheight,Image.SCALE_DEFAULT);//获取缩放后的图片大小
            //用于裁剪图像的 ImageFilter 类,也就是它要与 FilteredImageSource 对象结合使用，以生成现有图像的裁剪版本
            cropFilter = new CropImageFilter((int)(transX),(int)(transY), width, height);//图片要填充满整个模板 裁剪图片的大小等于模板的大小
            img = Toolkit.getDefaultToolkit().createImage(
                    new FilteredImageSource(image.getSource(), cropFilter));
            g.drawImage(img, startX, startY,width,height, null); // 绘制截取后的图
            if(nickname!=null){
                g.setFont(new Font("微软雅黑", Font.LAYOUT_LEFT_TO_RIGHT, width1/40));// 写入签名
                g.setColor(new Color(180,180,180));
                FontMetrics metrics;
                metrics = g.getFontMetrics(g.getFont());
                int textH = metrics.getHeight(); //字符串的高, 只和字体有关
                int textW; //字符串的宽
                textW = metrics.stringWidth(nickname);
                g.drawString(nickname, endX-textW,endY+textH);
            }
            g.dispose();
////            if(nickname!=null){
////                g.setFont(new Font("微软雅黑", Font.LAYOUT_LEFT_TO_RIGHT, width1/40));// 写入签名
////                g.setColor(new Color(180,180,180));
////                FontMetrics metrics;
////                metrics = g.getFontMetrics(g.getFont());
////                int textH = metrics.getHeight(); //字符串的高, 只和字体有关
////                int textW; //字符串的宽
////                textW = metrics.stringWidth(nickname);
////                g.drawString(nickname, endX-textW,endY+textH);
////            }
            FileOutputStream fileOutputStream = new FileOutputStream(result);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
            encoder.encode(bufferedImage1);
            fileOutputStream.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MetadataException e) {
            e.printStackTrace();
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        }


        return null;
    }
    public static Rectangle CalcRotatedSize(Rectangle src,int angel){
        // if angel is greater than 90 degree,we need to do some conversion.
        if(angel > 90){
            if(angel / 9%2 ==1){
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }

        double r = Math.sqrt(src.height * src.height + src.width * src.width ) / 2 ;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_height));
        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        return new java.awt.Rectangle(new Dimension(des_width, des_height));
    }
}
