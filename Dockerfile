FROM openjdk:8-jdk-alpine
ADD ./deploy/practice-0.0.2-SNAPSHOT.jar app.jar
COPY wallet.tar.gz /var/oracle
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/app.jar"]
