FROM openjdk:23
ARG JAR_FILE=target/*.jar
COPY /target/learnify-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]