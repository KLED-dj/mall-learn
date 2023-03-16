package com.kled.config;

import com.kled.component.DynamicSecurityMetadataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonSecurityConfig {
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource(){return new DynamicSecurityMetadataSource();}
}
