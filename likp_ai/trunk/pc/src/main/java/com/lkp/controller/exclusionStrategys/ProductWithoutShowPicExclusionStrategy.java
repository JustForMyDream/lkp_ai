package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

/**
 *
 */
public class ProductWithoutShowPicExclusionStrategy extends CommonExclusionStrategy{
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if ("tlkProductEntity".equals(fieldAttributes.getName())) return true;
        if ("tlkProductshowEntity".equals(fieldAttributes.getName())) return true;
        if ("tlkProductshowpicEntities".equals(fieldAttributes.getName())) return true;
        if  ("parentCP".equals(fieldAttributes.getName())) return true;
        return super.shouldSkipField(fieldAttributes);
    }
}
