package com.bootng.service;

import java.util.HashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration Class which defines a bean PaymentProp for two different profiles
 *
 * @author SiddB
 *
 */
@Configuration
public class PaymentProperties {

	@Profile("dev")
	@Bean(name = "PaymentProp")
	public HashMap<String, String> getPaymentServerDev() {
		HashMap<String, String> paymentMethod = new HashMap<>();
		paymentMethod.put("Currency", "USD");
		paymentMethod.put("ChargePercentage", "1");
		paymentMethod.put("Gateway", "BOA");
		return paymentMethod;
	}

	@Profile("prod")
	@Bean(name = "PaymentProp")
	public HashMap<String, String> getPaymentServerProd() {
		HashMap<String, String> paymentMethod = new HashMap<>();
		paymentMethod.put("Currency", "Pound");
		paymentMethod.put("ChargePercentage", "4");
		paymentMethod.put("Gateway", "BankOfEngland");
		return paymentMethod;
	}

}
