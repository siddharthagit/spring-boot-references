
# Spring Boot Application With Multiple Profiles

Sample project demonstrating how to use multiple profiles and multiple property files.

## Getting Started

This project uses Spring Boot, Maven and RESTTemplate to build a Spring Boot stand alone application which can calls REST API's and parse the result.

It has two controllers
###InfoController
it contains following end points
#### /details : Prints the details about different configurations.
#### /smtp    : Prints the details about Mail sender configuration.
#### /address : Prints the details about Mail address configuration.
###ProfileController
#### /address : Prints list of all active profiles.


## Different Examples

- Reading Property file and validating it (AddressProperties.java)
- Reading Property file using @Value (AddressProperties.java)
- Reading Property file using @ConfigurationProperties (ContactProperties.java)
- Reading Property from a profile specific configuration file (MailSenderProperties.java)
- Defining profile specific beans (PaymentProperties.java)


## Build Project

```sh
mvn install
mvn spring-boot:run
```


## Tutorial URL

[Spring Boot Profiles](https://www.bootng.com/2020/05/spring-boot-profile-example-details.html)
[Spring Boot Externalize Configuration](https://www.bootng.com/2020/05/spring-boot-externalizing-configuration.html)



## License
[MIT](LICENSE)
