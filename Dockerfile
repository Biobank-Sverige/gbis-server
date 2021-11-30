FROM maven:3-openjdk-11 as builder
COPY pom.xml pom.xml
RUN mvn dependency:resolve
COPY src src
RUN mvn clean package

FROM openjdk:11
COPY --from=builder target/gbis-server-*-spring-boot.jar ./gbis-server.jar
COPY example-data.csv .
CMD ["java","-jar", "gbis-server.jar"]
