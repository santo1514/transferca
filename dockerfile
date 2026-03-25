FROM openjdk:21-ea-jdk-slim
VOLUME /temp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]