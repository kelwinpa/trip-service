FROM openjdk:8-jre-alpine

VOLUME /tmp

ADD target/trip-service.jar trip-service.jar

ENTRYPOINT ["java", "-jar", "/trip-service.jar"]