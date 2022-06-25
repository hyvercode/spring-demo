FROM openjdk:11-jdk-slim
MAINTAINER hyvercode <huvercode@gmail.com>
ADD target/*.jar demo-service.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/demo-service.jar"]