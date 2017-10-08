package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;
import com.lkp.entity.TlkProductshowEntity;

/**
 * Created by chenxuantong on 16-11-10.
 */
public class OrderExclusionStrategyWithoutProductshow extends OrderExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if ("tlkProductshowEntities".equals(fieldAttributes.getName())) return true;
        if("wechatInfo".equals(fieldAttributes.getName())) return true;
        return super.shouldSkipField(fieldAttributes);
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        if(aClass.equals(TlkProductshowEntity.class)) return true;
        return super.shouldSkipClass(aClass);
    }
}
