package com.sdargol;

import com.sdargol.protect.IPData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class RestTerminalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTerminalApplication.class, args);
	}

	@Bean
	public ConcurrentHashMap<String, IPData> ipStrangeStorage(){
		return new ConcurrentHashMap<>();
	}

}
