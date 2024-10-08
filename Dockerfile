FROM openjdk:17-jdk
EXPOSE 8080
ADD target/eventmanagementsystem.jar 1.0.0.jar eventmanagementsystem.jar
ENTRYPOINT ["java", "-jar", "/eventmanagementsystem.jar"]