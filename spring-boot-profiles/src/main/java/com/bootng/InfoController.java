package com.bootng;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bootng.service.AddressProperties;
import com.bootng.service.ContactProperties;
import com.bootng.service.MailSenderProperties;

@RestController
public class InfoController {

	@Autowired
	public MailSenderProperties mailSender;

	@Autowired
	private ContactProperties contact;

	@Autowired
	private AddressProperties address;

	@Autowired
	private ApplicationContext applicationContext;

	@Value("${appserver.version}")
	private String paymentServerVer;

	@RequestMapping(value = { "/details" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDetails() {

		// Get the Bean with name PaymentProp
		HashMap<String, String> paymentProp = (HashMap<String, String>) applicationContext.getBean("PaymentProp");

		// Get the payment Server version from application.properties file
		String paymentInfo = "\n Payment Server Version:= " + paymentProp.toString();

		// Print the mail configurations
		String smtpInfo = "\n Mail Server SMTP Host: " + mailSender.getSmtpHost() + " SMTP Port:"
				+ mailSender.getSmtpPort();

		// Print the contact details
		String info = "\nContactInfo From=" + contact.getFrom() + " Email=" + contact.getFromEmail();
		String addressInfo = "\n AddressInfo Street=" + address.getStreet() + " City=" + address.getCity() + " State="
				+ address.getState() + " Zip=" + address.getZip();

		String result = paymentInfo + smtpInfo + info + addressInfo;
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@RequestMapping(value = { "/smtp" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmailConf() {

		String result = "<br>Mail Server SMTP Host: " + mailSender.getSmtpHost() + " SMTP Port:"
				+ mailSender.getSmtpPort();

		return new ResponseEntity<String>("email conf details" + result, HttpStatus.OK);
	}

	@RequestMapping(value = { "/address" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAddress() {

		String info = "From=" + contact.getFrom() + " Email=" + contact.getFromEmail();
		String addressInfo = " Street=" + address.getStreet() + " City=" + address.getCity() + " State="
				+ address.getState() + " Zip=" + address.getZip();

		return new ResponseEntity<String>(info + addressInfo, HttpStatus.OK);
	}

}
