package com.kled.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan({"com.kled.mbg.mapper","com.kled.dao"})
@EnableTransactionManagement
public class MyBatisConfig {
}
