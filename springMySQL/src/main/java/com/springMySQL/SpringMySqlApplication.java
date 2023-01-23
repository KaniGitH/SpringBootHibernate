package com.springMySQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.springMySQL.entity")
@EnableJpaRepositories("com.springMySQL.repository")
public class SpringMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMySqlApplication.class, args);
	}

}
