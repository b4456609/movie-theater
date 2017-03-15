FROM openjdk:8-alpine

WORKDIR /opt/app/

EXPOSE 8080

COPY ./build/libs/theater-0.0.1-SNAPSHOT.jar /opt/app/

CMD ["java", "-jar", "theater-0.0.1-SNAPSHOT.jar"]