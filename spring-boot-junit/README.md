
# Spring Boot App Testing with JUnit and Mokito

Sample project demonstrating how to use JUnit 5 and Mokito for testing

## Getting Started

This project uses Spring Boot, Maven and Junit 5 and Mokito to build a Spring Boot application which provides two REST API's. We then have Junit test cases written to test different Use cases.

## How it works
This project contains a RestController serving two end points
- /blogs : Get list of blogs
- /blogs/{ID} : Get details of a blog by its id
And a service which deals with creating and retrieving Blog Items.

We have Juint 5 test cases as follows

- Writing Test cases for the Service
- Writing Test cases for RESTController
- Using Mokito to mock service layer and then write test cases for controller


## Build Project

```sh
mvn install
mvn spring-boot:run
```

## Run Project

```
mvn test
```


## Tutorial URL

[JUnit 5 with Mockito and Spring Boot](https://www.bootng.com/2020/05/unit-testing-spring-boot-with-junit5.html)


## License
[MIT](LICENSE)
