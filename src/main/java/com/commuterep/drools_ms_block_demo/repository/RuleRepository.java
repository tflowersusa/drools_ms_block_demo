package com.commuterep.drools_ms_block_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commuterep.drools_ms_block_demo.rule.Rule;

public interface RuleRepository extends JpaRepository<Rule, Long> {

}
