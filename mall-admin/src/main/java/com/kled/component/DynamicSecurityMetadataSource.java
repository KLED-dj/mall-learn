package com.kled.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.Map;

/**
 * 动态权限数据源，用于获取动态权限规则
 */
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
// TODO 未完善
    private static Map<String, ConfigAttribute> configAttributeMap = null;
    @Autowired
    
    
    public void clearDataSource() {
        configAttributeMap.clear();
        configAttributeMap = null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
