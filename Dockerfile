FROM openjdk:17-jdk-slim

EXPOSE 8585
 
ARG JAR_FILE=target/spring-rest-practice-0.0.1-SNAPSHOT.jar
 
ADD ${JAR_FILE} spring-rest-practice.jar
 
ENTRYPOINT ["java","-jar","/spring-rest-practice.jar"]