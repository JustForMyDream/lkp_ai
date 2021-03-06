package com.lkp.controller;

import java.util.List;

/**用于解析数据的中间类
 * Created by chuan on 2016/11/25.
 */
public class YingjiJson {
    private String id;
    private String title;
    private String des;
    private String music;
    private YingjiCover cover;
    private List<Yingjipic> Yingjipics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<Yingjipic> getYingjipics() {
        return Yingjipics;
    }

    public void setYingjipics(List<Yingjipic> Yingjipics) {
        this.Yingjipics = Yingjipics;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public YingjiCover getCover() {
        return cover;
    }

    public void setCover(YingjiCover cover) {
        this.cover = cover;
    }
}
