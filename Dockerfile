# build backend service
FROM maven:3.5-jdk-8

RUN mkdir -p /mvn_build
WORKDIR /mvn_build
COPY . /mvn_build
RUN mvn package -P docker -DskipTests
VOLUME /mvn_build


# Run backend service
FROM openjdk:8-jdk-alpine

COPY --from=0 /mvn_build/target/beneficiary-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
