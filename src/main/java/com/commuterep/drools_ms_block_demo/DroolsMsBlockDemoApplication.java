package com.commuterep.drools_ms_block_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.commuterep.drools_ms_block_demo.repository.RuleRepository;
import com.commuterep.drools_ms_block_demo.repository.impl.RuleRepositoryImpl;
import com.commuterep.drools_ms_block_demo.service.RuleService;
import com.commuterep.drools_ms_block_demo.service.impl.RuleServiceImpl;

@SpringBootApplication
public class DroolsMsBlockDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsMsBlockDemoApplication.class, args);
	}
	
	@Bean
	public RuleRepository ruleRepository() {
		return new RuleRepositoryImpl();
	}
	
	@Bean
	public RuleService ruleService() {
		return new RuleServiceImpl();
	}

}
