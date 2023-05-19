package com.wonsi.statrip.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = "com.wonsi.statrip.model.repository"
)
public class DatabaseConfiguration {}