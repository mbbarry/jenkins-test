FROM openjdk:17

EXPOSE 8080

COPY ./target/java-jenkins-build-1.0-SNAPSHOT.jar /user/app/
WORKDIR /user/app

ENTRYPOINT ["java", "-jar", "java-jenkins-build-1.0-SNAPSHOT.jar"]