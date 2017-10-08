package com.lkp.controller;

/**
 * Created by 审判之月 on 2017/1/6.
 */
public class YingjiCover{
    /**
     * 封面图片类型
     * user 表示微信上传图片
     * service 服务器图片
     */
    private String type;
    /**
     * 封面图片
     * 当type为user时 该值代表微信临时素材id
     * 当type为service时 该值代表服务器图片路径
     */
    private String targetId;

    private String src;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
