
# Spring Boot RESTTemplate Project

Sample project demonstrating how to crate REST API in Spring Boot.

## Getting Started

This project uses Spring Boot, Maven to create REST API's.

## How it works
This project implements multiple REST API's with different styles supported by Spring Boot.


##REST API URL's
Following are the list of REST API's built in this project

- GET  /blogapi/v1/blogs
- GET  /blogapi/v1/blogs/{ID}
- GET  /blogapi/v2/blogs/{ID}
- POST /blogapi/v1/blogs

- GET  /blogapi/v1/categories
- GET  /blogapi/v1/categories/{ID}
- POST /blogapi/v1/categories

- GET  /blogapi/v1/tags
- GET  /blogapi/v2/tags
- GET  /blogapi/v3/tags

- GET  /blogapi/v1/comments
- GET  /blogapi/v2/comments/{ID}
- POST /blogapi/v3/comments
- PUT  /blogapi/v2/comments/{ID}

- GET  /helloapi/welcome
- GET  /helloapi/welcome2
- GET  /helloapi/welcome3


##Different Examples
- Using @Controller annotation -> CategoryAPIController
- Using @ResponseBody annotation -> CategoryAPIController
- Using @RestController annotation -> BlogAPIController
- Using ObjectMapper -> BlogAPIController
- Using @PathVariable -> BlogAPIController
- Work with ResponseEntity -> HelloController

- Using @GetMapping annotation -> CommentsAPIController
- Using @PostMapping annotation -> CommentsAPIController

- Using @ControllerAdvice -> GlobalExceptionHandler

## Build Project

```sh
mvn install
mvn spring-boot:run
```


## Tutorial URL

[Spring Boot REST Example](http://www.bootng.com/2020/05/spring-boot-rest-example.html)
[Controller Advise Example](https://www.bootng.com/2020/06/spring-boot-controlleradvise-example.html)



## License
[MIT](LICENSE)
