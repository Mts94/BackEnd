FROM amazoncorretto:11-alpine-jdk
MAINTAINER mts94
COPY target/mts-0.0.1-SNAPSHOT.jar mts-0.0.1-SNAPSHOT.jar
ENTRYPOINT  ["java","-jar","/mts-0.0.1-SNAPSHOT.jar"]

