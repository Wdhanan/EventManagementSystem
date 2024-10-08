FROM openjdk:17-jdk
EXPOSE 8080
ADD target/eventmanagementsystem-0.0.1-SNAPSHOT.jar eventmanagementsystem.jar
ENTRYPOINT ["java", "-jar", "/eventmanagementsystem.jar"]
