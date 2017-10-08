package com.lkp.controller.exclusionStrategys;

import com.google.gson.FieldAttributes;

/**
 *
 */
public class SysInforExclusionStrategy extends CommonExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if("orderproductEntities".equals(fieldAttributes.getName())) return true;
        if("tlkProductshowEntities".equals(fieldAttributes.getName())) return true;
        if("tlkCpfwxqEntitys".equals(fieldAttributes.getName())) return true;
        if("tlkYingjipicEntities".equals(fieldAttributes.getName())) return true;
        if("tlkProductshowEntities".equals(fieldAttributes.getName())) return true;
        return super.shouldSkipField(fieldAttributes);
    }
}
