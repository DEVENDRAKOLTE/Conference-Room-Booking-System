package com.ConferceRoom.ConferceRoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.Dao")
@EntityScan("com.Entity")
@ComponentScan({"com.Dao","com.Entity","Controller","com.service"})
public class ConferceRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferceRoomApplication.class, args);
	}

	
}

