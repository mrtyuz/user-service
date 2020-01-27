# USER SERVICE

A Spring Boot based application to get data with async calls end expose the result by a REST endpoint.

### Technologies
- Java 8
- Spring Boot
- Log4j
- Lombok
- Mockito

### Available Services

| HTTP METHOD | PATH | USAGE |
| -----------| ------ | ------ |
| GET | /user/{userId}| expose user information and user comments 

### Requirements

For building and running the application you need:

```
JDK 1.8
Maven
```

### Running the application locally

```
mvn spring-boot:run
```

### Installing

```
mvn clean install
```

## Running the tests

```
mvn test
```


## Authors

* **Murat Yuzkollar**
mrtyuz@gmail.com