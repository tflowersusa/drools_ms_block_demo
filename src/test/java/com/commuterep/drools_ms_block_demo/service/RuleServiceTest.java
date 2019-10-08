package com.commuterep.drools_ms_block_demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.commuterep.drools_ms_block_demo.ms.dto.CartDto;
import com.commuterep.drools_ms_block_demo.ms.dto.impl.CartDtoImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleServiceTest {
	 
	@Test
	public void executeRuleTest() {
		String rule = ""
				+ "package com.commuterep.drools_ms_block_demo.ms.dto; \n"
				+ "dialect \"mvel\" \n"
				+ "import java.lang.String \n"
				+ "import com.commuterep.drools_ms_block_demo.ms.dto.CartDto \n"
				+ "rule \"123\" \n"
				+ "when \n"
				+ "  $cart : CartDto() \n"
				+ "  $couponCode : String ( toString() == \"Running\" ) from $cart.couponCodes \n"
				+ "then \n"
				+ "  System.out.println(\"*** yeet! ***\"); \n"
				+ "end";
		
		CartDto cartDto = new CartDtoImpl();
		cartDto.getCouponCodes().add("Running");
		
		executeRule(rule, cartDto);
	}
	
	private void executeRule(String rule, CartDto cartDto) {
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kfs = kieServices.newKieFileSystem();
		
		kfs.write("src/main/resources/rule.drl", rule);
		
		KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();

		// check there have been no errors for rule setup
		
//		Results results = kieBuilder.getResults();
//		if( results.hasMessages( Message.Level.ERROR ) ){
//		    System.out.println( results.getMessages() );
//		    throw new IllegalStateException( "### errors ###" );
//		}
		
		KieContainer kieContainer = kieServices.newKieContainer( kieBuilder.getKieModule().getReleaseId() );
		KieSession kieSession = kieContainer.newKieSession();

		// insert facts and fire rules
		
		kieSession.insert(cartDto);
		
		kieSession.fireAllRules();
		kieSession.dispose();
	}

}
