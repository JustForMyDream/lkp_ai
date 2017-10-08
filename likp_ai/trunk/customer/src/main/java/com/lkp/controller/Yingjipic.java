package com.lkp.controller;

/**用于解析数据的中间类
 * Created by chuan on 2016/11/25.
 */
public class Yingjipic {
    /**
     * 图片类型 user（用户手机选择） order(订单图片),service(原影集图片)
     */
    private String type;
    /**
     * type为user时为上传至微信的图片servid ,type为order时为图片id,原影集图片id
     */
    private String targetId;
    /**
     * 文字描述
     */
    private String des;

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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
