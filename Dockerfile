FROM openjdk:8
ADD target/tiny-url-data-0.0.1-SNAPSHOT.jar tiny-url-data-0.0.1-SNAPSHOT.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "tiny-url-data-0.0.1-SNAPSHOT.jar"]