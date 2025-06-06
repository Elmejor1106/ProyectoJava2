FROM openjdk:17
COPY "target/gestexpo-0.0.1-SNAPSHOT" "app.jar"
EXPOSE 1000
ENTRYPOINT ["java", "-jar", "app.jar"]
