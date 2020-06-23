
# Spring Boot + Thymeleaf Web App

Sample project demonstrating how to build a Web Application in Spring Boot using Thymeleaf as a template engine. It can be used for reference or for starting a new RESTTemplate project.

## Getting Started

This project uses Spring Boot, Maven and Thymeleaf to build a Spring Boot web application which contains two pages 1) a Login Page 2) a Blog list page.

## How it works
This project implements two different Controllers for two different pages.
The first page is mapped to /login and the other page is mapped to /blog URL respectively
When the Application receives request, one of the corresponding controller is used to serve the
request.
Each controller process the request and uses Thymeleaf templates defined under templates folder to build the HTML page and return to clint


## Build Project

```sh
mvn install
mvn spring-boot:run
```

## Access the application

```sh
Navigate to localhost:8080/login and localhost:8080/blog URL using browser.
```


## Tutorial URL

[Spring Boot With Thymeleaf](http://www.bootng.com/2020/05/spring-boot-web-app-with-thymeleaf.html)


## License
[MIT](LICENSE)
