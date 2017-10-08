package com.lkp.controller;

import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.lkp.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 */
@Controller
@RequestMapping("util")
public class GetMeidiaController {
    @Autowired
    AccessTokenService accessTokenService;

    MediaUtil mediaUtil = new MediaUtil();

    @RequestMapping("media")
    public void getMedia(@RequestParam("id") String id, HttpServletResponse response){
        mediaUtil.getMedia(accessTokenService.getAccessToken(), id, new MediaOperate() {
            @Override
            public void InputstreamOperate(InputStream inputStream) {
                try {
                    OutputStream outputStream = response.getOutputStream();
                    byte[] data = new byte[1048576];
                    boolean index = false;

                    int index1;
                    while ((index1 = inputStream.read(data)) != -1) {
                        outputStream.write(data, 0, index1);
                    }
                    inputStream.close();
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
