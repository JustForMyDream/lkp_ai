package com.lkp.controller.exclusionStrategys;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 *
 */
public class CollectionProductExclusionStrategy extends CommonExclusionStrategy {
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if ("tlkProductEntity".equals(fieldAttributes.getName())) return true;
        if ("tlkProductshowEntity".equals(fieldAttributes.getName())) return true;
        if ("parentCP".equals(fieldAttributes.getName())) return true;
        if ("tlkYingjiEntity".equals(fieldAttributes.getName())) return true;
        if ("tlkProductshowEntities".equals(fieldAttributes.getName())) return true;
        if ("tlkCpfwxqEntitys".equals(fieldAttributes.getName())) return true;
        if ("tlkYingjipicEntities".equals(fieldAttributes.getName())) return true;
        if ("itemZsyj".equals(fieldAttributes.getName())) return true;
        return super.shouldSkipField(fieldAttributes);
    }

    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
