package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

/**
 * Created by cccxt on 2016/10/28.
 */
public class OrderExclusionStrategy extends CommonExclusionStrategy {
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if("tlkProductEntity".equals(fieldAttributes.getName())) return true;
        if("tlkProductshowEntity".equals(fieldAttributes.getName()))return true;
        if("tlkUserEntity".equals(fieldAttributes.getName()) ) return true;
        if("tlkOrderEntity".equals(fieldAttributes.getName()))return true;
        if("orderproductEntities".equals(fieldAttributes.getName())) return true;
        if("tlkPhotographerEntity".equals(fieldAttributes.getName())) return true;
        if("tlkProductshowEntities".equals(fieldAttributes.getName())) return true;
        if("tlkWechatpayEntitys".equals(fieldAttributes.getName())) return true;
        if("wechatInfo".equals(fieldAttributes.getName())) return true;
        return super.shouldSkipField(fieldAttributes);
    }
}
