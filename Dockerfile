FROM amazoncorretto:11-alpine-jdk
MAINTAINER MTS94
COPY target/mts-0.0.1-SNAPSHOT.jar mts-app.jar
ENTRYPOINT ["java","-jar", "/mts-app.jar"]


