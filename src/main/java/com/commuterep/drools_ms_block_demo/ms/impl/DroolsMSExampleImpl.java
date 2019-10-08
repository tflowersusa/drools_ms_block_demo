package com.commuterep.drools_ms_block_demo.ms.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commuterep.drools_ms_block_demo.ms.DroolsMSExample;
import com.commuterep.drools_ms_block_demo.service.RuleService;

@RestController
public class DroolsMSExampleImpl implements DroolsMSExample {
	
	@Autowired
	private RuleService ruleService;

	@PostMapping(path = "/foo")
	public String foo() {
		return null;
	}
}
