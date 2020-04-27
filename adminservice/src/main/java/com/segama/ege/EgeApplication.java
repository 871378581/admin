package com.segama.ege;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.segama.ege.*"})
@MapperScan("com.segama.ege.repository")
public class EgeApplication {
	public static void main(String[] args) {
		SpringApplication.run(EgeApplication.class, args);
	}

}
