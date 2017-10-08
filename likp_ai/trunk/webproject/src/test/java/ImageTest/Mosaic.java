package ImageTest;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


/**
 *
 */
public class Mosaic {
    @Test
    public void mosic(){
       /* String image1URL = "E:\\mosaicTest\\png.png";
        String imageURL2 = "E:\\mosaicTest\\_8BD1lEW8Zlf0Xlq4wYO0AzCx9u2T4-cwDcxHLA5-8oqIluesafWB4rjgQrFF9m_.jpg";
        int startX=53;
        int startY=114;
        int endX=699;
        int endY=759;
        int width=Math.abs(endX-startX);
        int height=Math.abs(endY-startY);
        File imgFile1 = new File(image1URL);
        File imgFile2 = new File(imageURL2);
        try {
            Image img1 = ImageIO.read(imgFile1);
            int width1 = img1.getWidth(null);
            int height1 = img1.getHeight(null);
            //System.out.println("width1:"+width1+";"+"height1:"+height1);
            BufferedImage bufferedImage1 = new BufferedImage(width1,height1,BufferedImage.TYPE_INT_RGB);
            Graphics g = bufferedImage1.createGraphics();
            Image img2 = ImageIO.read(imgFile2);
            int width2 = img2.getWidth(null);
            int height2 = img2.getHeight(null);
            //若图片太宽
            double scale = (double)width/(double)height;
            double scale2 = (double)width2/(double)height2;
            if(scale2>scale){
                double ratio = (double)height/(double)height2;
                int adjustHeight=height;
                int adjustWidth = (int)(ratio*width2);
                g.drawImage(img2,startX-((adjustWidth-width)/2),startY,adjustWidth,adjustHeight,null);
            }
            //若图片太窄
            else{
                double ratio = (double)width/(double)width2;
                int adjustHeight=(int)(ratio*height2);
                int adjustWidth = width;
                g.drawImage(img2,startX,startY-((adjustHeight-height)/2),adjustWidth,adjustHeight,null);
            }
            g.drawImage(img1,0,0,width1,height1,null);
            g.dispose();
            File imgFile3 = new File("E:\\mosaicTest\\"+ UUID.randomUUID().toString()+".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(imgFile3);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
            encoder.encode(bufferedImage1);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
