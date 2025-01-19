package com.backend;

import com.backend.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableScheduling
public class ItemManagementApplication {
   @Autowired
	EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(ItemManagementApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		emailSenderService.sendEmail("admin@example.com",
				"This is Subject",
				"This is Body of Email");
	}

}
