# Pokemon API

## Tech Stack
- Java 11
- Spring Boot 2.6.6
- Maven
- QueryDSL
- Lombok


## How to start the project ?
Run the below commands at the root of the project directory.
```
mvn clean install
```
Run spring boot application.
```
mvn spring-boot:run
```

## PostmanCollection directory
\src\main\resources\postmancollection

## Example Request URL
### Pagination
http://localhost:8080/pokemon?page=0&size=10
### Filtering
http://localhost:8080/pokemon?name=Wartortle

http://localhost:8080/pokemon?type1=Grass

## H2 DB
http://localhost:8080/h2-console
user name: test
pass: test

