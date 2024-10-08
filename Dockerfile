FROM openjdk:17-jdk
WORKDIR /app
COPY target/EventManagementSystem-0.0.1-SNAPSHOT.jar eventmanagementsystem.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/eventmanagementsystem.jar"]
