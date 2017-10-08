package com.lkp.util;

import com.google.gson.Gson;


import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 字符打印工具类
 * Created by cccxt on 2016/7/6.
 */
public class ResponseUtil {
    private static Gson gson = new Gson();
    private static final String RESPONSE_CHARSET = "UTF-8";

    public static void response(HttpServletResponse respon, String message) {

        try {
            respon.setContentType("text/html;charset=" + RESPONSE_CHARSET);
            PrintWriter writer = respon.getWriter();
            writer.write(message);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void response(HttpServletResponse respon, Object message) {
        response(respon, gson.toJson(message));
    }
}
