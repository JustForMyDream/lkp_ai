package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

/**
 * Created by cccxt on 2016/10/28.
 *
 */
public class ProductWithShowPicExclusionStrategy extends CommonExclusionStrategy{
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if ("tlkProductEntity".equals(fieldAttributes.getName())) return true;
        if ("tlkProductshowEntity".equals(fieldAttributes.getName())) return true;
        if  ("parentCP".equals(fieldAttributes.getName())) return true;
        return super.shouldSkipField(fieldAttributes);
    }

    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
