package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

/**
 * Created by cccxt on 2016/10/31.
 */
public class YingjiExclusionStrategy extends CommonExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if("tlkYingjiEntity".equals(fieldAttributes.getName())) return true;
        return super.shouldSkipField(fieldAttributes);
    }
}
