
# Spring Boot RESTTemplate Project

Sample project demonstrating RESTTEmplate in Spring Boot. It can be used for reference or for starting a new RESTTemplate project.

## Getting Started

This project uses Spring Boot, Maven and RESTTemplate to build a Spring Boot stand alone application which can calls REST API's and parse the result.

## How it works
This project implements multiple CommandRunners which will parse the respective URL's and print the response to the console.
The first Class is LoadAllGithubEndpoints which calls GET https://api.github.com to retrieve all the api's supported by github and then prints those end points in the console

The second Class is LoadGithubRepo which calls https://api.github.com/users/siddharthagit/repos to retrieve all the Github repo for the specified user and prints them in the console.

## Build Project

```sh
mvn install
mvn spring-boot:run
```


## Tutorial URL

[Spring Boot RestTemplate](http://www.bootng.com/2020/06/spring-boot-rest-template-example.html)


## License
[MIT](LICENSE)
