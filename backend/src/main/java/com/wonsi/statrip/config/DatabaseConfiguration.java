package com.wonsi.statrip.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = {"com.wonsi.statrip.model.repository", "com.wonsi.statrip.model.repository.plan"}
)
public class DatabaseConfiguration {}