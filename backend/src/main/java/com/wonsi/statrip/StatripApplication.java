package com.wonsi.statrip;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatripApplication {
	@Value("${spring.datasource.password}")
    private static String dbPassword;


	public static void main(String[] args) {
		System.out.println(dbPassword + "---------");
		SpringApplication.run(StatripApplication.class, args);
	}

}
