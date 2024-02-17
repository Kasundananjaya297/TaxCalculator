package com.example.FinalProject;

import com.example.FinalProject.utility.IDGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FinalProjectApplication implements CommandLineRunner {
	@Autowired
	private IDGenerator idGenerator;
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(idGenerator.getMaxEmployeeId());
	}
}
