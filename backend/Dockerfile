FROM openjdk:17-jdk-alpine

LABEL authors="Rodrigo Motta"

COPY target/petshop-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]