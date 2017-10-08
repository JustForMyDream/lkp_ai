package com.lkp.entity.vo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

/**
 *
 */
public class SelectXJEntity {
    private String ITEM_NAME;
    private String PJXJ;
    private String ITEM_HEADIMG;
    private String ITEM_HEADIMGURL;
    private String ITEM_SYSHDLX;
    private String ITEM_COUNTRY;
    private String ITEM_PROVINCE;

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public String getPJXJ() {
        return PJXJ;
    }

    public void setPJXJ(String PJXJ) {
        this.PJXJ = PJXJ;
    }

    public String getITEM_HEADIMG() {
        return ITEM_HEADIMG;
    }

    public void setITEM_HEADIMG(String ITEM_HEADIMG) {
        this.ITEM_HEADIMG = ITEM_HEADIMG;
    }

    public String getITEM_HEADIMGURL() {
        return ITEM_HEADIMGURL;
    }

    public void setITEM_HEADIMGURL(String ITEM_HEADIMGURL) {
        this.ITEM_HEADIMGURL = ITEM_HEADIMGURL;
    }

    public String getITEM_SYSHDLX() {
        return ITEM_SYSHDLX;
    }

    public void setITEM_SYSHDLX(String ITEM_SYSHDLX) {
        this.ITEM_SYSHDLX = ITEM_SYSHDLX;
    }

    public String getITEM_COUNTRY() {
        return ITEM_COUNTRY;
    }

    public void setITEM_COUNTRY(String ITEM_COUNTRY) {
        this.ITEM_COUNTRY = ITEM_COUNTRY;
    }

    public String getITEM_PROVINCE() {
        return ITEM_PROVINCE;
    }

    public void setITEM_PROVINCE(String ITEM_PROVINCE) {
        this.ITEM_PROVINCE = ITEM_PROVINCE;
    }

    public String getITEM_CITY() {
        return ITEM_CITY;
    }

    public void setITEM_CITY(String ITEM_CITY) {
        this.ITEM_CITY = ITEM_CITY;
    }

    private String ITEM_CITY;

}
