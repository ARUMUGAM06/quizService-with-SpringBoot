FROM openjdk:17-jdk-alpine

WORKDIR /starterproject

ARG WAR_FILE=target/*.jar

COPY ${WAR_FILE} starterproject.jar

ENTRYPOINT ["java","-jar","/starterproject.jar"]

EXPOSE 8082