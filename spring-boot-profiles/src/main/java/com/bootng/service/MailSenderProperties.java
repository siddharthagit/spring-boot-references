package com.bootng.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Populate the MailSenderProperties by reading a profile specific properties file
 * It reads the active profile name from environment and try to read corresponding
 * property file.
 * For instance for "prod" profile it will read application-prod.properties.
 * @author SiddB
 *
 */
@Component
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class MailSenderProperties {

	@Value("${mail.smtp.host}")
	private String smtpHost;

	@Value("${mail.smtp.port}")
	private Integer smtpPort;

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public Integer getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}

}
