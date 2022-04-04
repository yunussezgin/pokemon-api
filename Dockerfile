FROM openjdk:11
ADD target/pokemon-api-0.0.1-SNAPSHOT.jar pokemon-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/pokemon-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080