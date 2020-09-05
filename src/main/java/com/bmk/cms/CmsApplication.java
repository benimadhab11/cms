package com.bmk.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.bmk.cms.service","com.bmk.cms.controller","com.bmk.cms.config","com.bmk.cms.dto"})
@EntityScan(basePackages = {"com.bmk.cms.model"})
@EnableJpaRepositories(basePackages = {"com.bmk.cms.repo"})
public class CmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

}
