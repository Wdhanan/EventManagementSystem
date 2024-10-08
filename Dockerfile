FROM openjdk:17-jdk

WORKDIR /app

COPY target/eventmanagementsystem-0.0.1-SNAPSHOT.jar /app/eventmanagementsystem.jar

EXPOSE 8080

CMD ["java", "-jar", "eventmanagementsystem.jar"]