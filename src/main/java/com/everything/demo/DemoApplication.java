package com.everything.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.everything.demo.config.DynamicDataSourceRegister;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.everything.demo"})
@Import({DynamicDataSourceRegister.class})
@ComponentScan({"com.everything.demo"})
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
