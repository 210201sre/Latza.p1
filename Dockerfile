FROM maven:3.6.3-openjdk-11 as builder

COPY pom.xml pom.xml
COPY src/ src/

RUN mvn clean package

FROM java:8 as runner

EXPOSE 7000

ARG DB_URL
ARG DB_USERNAME
ARG DB_PASSWORD

COPY --from=builde target/project1-jar-with-dependencies.jar app jar

ENTERYPOINT [ "java", "-jar", "app.jar"]

