package com.lkp.controller.exclusionStrategys;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 *
 */
public class CommonExclusionStrategy implements ExclusionStrategy {
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if("lastmodified".equals(fieldAttributes.getName())) return true;
        if("formname".equals(fieldAttributes.getName())) return true;
        if("state".equals(fieldAttributes.getName())) return true;
        if("author".equals(fieldAttributes.getName())) return true;
        if("authorDeptIndex".equals(fieldAttributes.getName())) return true;
        if("formid".equals(fieldAttributes.getName())) return true;
        if("istmp".equals(fieldAttributes.getName())) return true;
        if("applicationid".equals(fieldAttributes.getName())) return true;
        if("stateint".equals(fieldAttributes.getName())) return true;
        if("auditornames".equals(fieldAttributes.getName())) return true;
        if("lastmodifier".equals(fieldAttributes.getName())) return true;
        if("domainid".equals(fieldAttributes.getName())) return true;
        if("auditorlist".equals(fieldAttributes.getName())) return true;
        return false;
    }

    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
