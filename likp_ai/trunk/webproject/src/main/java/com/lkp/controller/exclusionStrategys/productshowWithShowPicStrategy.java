package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

/**
 *
 */
public class productshowWithShowPicStrategy extends CommonExclusionStrategy {
    public boolean shouldSkipField(FieldAttributes fieldAttributes){
        if ("tlkProductshowEntity".equals(fieldAttributes.getName())||"tlkProductEntity".equals(fieldAttributes.getName())) return true;
        return super.shouldSkipField(fieldAttributes);
    }
}
