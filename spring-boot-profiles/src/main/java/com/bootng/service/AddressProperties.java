package com.bootng.service;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/** Configuration Class that reads Address from a property file
 * office-address.properties. It also validates that the values
 * are valid using @Validated annotation
 * 
 * **/

@Component
@PropertySource("classpath:office-address.properties")
@Validated
public class AddressProperties {

	@Value("${address.street}")
	private String street;

	@Value("${address.city}")
	private String city;

	@Value("${address.state}")
	private String state;

	@NotNull
	@Value("${address.zip}")
	private String zip;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
