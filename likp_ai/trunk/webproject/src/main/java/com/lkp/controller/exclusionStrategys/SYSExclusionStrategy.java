package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

/**
 *
 */
public class SYSExclusionStrategy extends CommonExclusionStrategy {
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return("orderproductEntities".equals(fieldAttributes.getName()))||super.shouldSkipField(fieldAttributes);
    }
}
