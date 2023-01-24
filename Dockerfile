FROM amazoncorretto:11-allpine-jdk
MAINTAINER mts94
COPY target/mts-0.0.1-SNAPSHOT.jar mts94.jar
ENTRYPOINT  ["java","-jar","/mts94.jar"]

