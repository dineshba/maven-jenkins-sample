FROM adoptopenjdk/openjdk11:alpine-slim
WORKDIR app
COPY target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]