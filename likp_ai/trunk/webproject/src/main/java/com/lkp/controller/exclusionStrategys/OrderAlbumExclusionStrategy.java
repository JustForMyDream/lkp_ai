package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

import java.nio.file.attribute.FileAttribute;

/**
 *
 */
public class OrderAlbumExclusionStrategy extends CommonExclusionStrategy{
    public boolean shouldSkipField(FieldAttributes fileAttributes){
        if("tlkWechatpayEntitys".equals(fileAttributes.getName())) return true;
        if("tlkCpfwxqEntitys".equals(fileAttributes.getName()))return true;
        if("tlkProductshowEntities".equals(fileAttributes.getName()) ) return true;
        if("tlkYingjipicEntities".equals(fileAttributes.getName()) ) return true;
        if("orderproductEntities".equals(fileAttributes.getName()) ) return true;
        if("wechatInfo".equals(fileAttributes.getName()))return true;
        if("itemUserid".equals(fileAttributes.getName())) return true;
        return super.shouldSkipField(fileAttributes);
    }
}
