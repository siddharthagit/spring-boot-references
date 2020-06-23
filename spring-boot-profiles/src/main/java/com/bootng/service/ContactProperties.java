package com.bootng.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
/**
 * Configuration class which reads Contact details from a
 * property file.
 * @author SiddB
 *
 */
@Component
@ConfigurationProperties(prefix = "contact")
@PropertySource("classpath:office-address.properties")
@Validated
public class ContactProperties {

	@NotNull
	private String from;

	@Email
	private String fromEmail;

	@Value("${contact.fromTwitter}")
	private String twitterHandle;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getTwitterHandle() {
		return twitterHandle;
	}

	public void setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
	}

}
