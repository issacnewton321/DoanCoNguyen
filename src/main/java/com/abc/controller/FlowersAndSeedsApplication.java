package com.abc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan({"com.abc.controller","com.abc.jwt.configs","com.abc.jwt.filters","com.abc.jwt.util"})
@EntityScan("com.abc.entity")
@EnableAutoConfiguration()
@EnableJpaRepositories("com.abc.repository")
public class FlowersAndSeedsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowersAndSeedsApplication.class, args);
	}

}
