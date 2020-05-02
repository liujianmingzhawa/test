package com.everything.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadConifg {

    
    @Bean
    public String uploadExcelDir(@Value("${upload.excel-dir}") String uploadExcelDir) {
    	return uploadExcelDir;
    }
}
