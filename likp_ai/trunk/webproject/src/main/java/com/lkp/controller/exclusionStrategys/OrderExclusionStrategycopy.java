package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

/**
 *
 */
public class OrderExclusionStrategycopy extends OrderExclusionStrategy {
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if("orderproductimgEntities".equals(fieldAttributes.getName()))return true;
        if("tlkCpfwxqEntitys".equals(fieldAttributes.getName()))return true;
        return super.shouldSkipField(fieldAttributes);
    }
}
