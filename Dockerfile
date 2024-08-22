FROM openjdk:17-jdk-alpine

WORKDIR /starterproject

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} starterproject.jar

ENTRYPOINT ["java","-jar","/starterproject.jar"]

EXPOSE 8082