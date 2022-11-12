FROM openjdk:11
WORKDIR /
COPY target/executable-jar-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Ditermis_config=../path/config/", "-jar", "/app.jar"]