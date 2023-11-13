FROM openjdk:8-jdk-alpine
ADD ./deploy/practice-0.0.2-SNAPSHOT.jar app.jar
RUN mkdir /var/oracle
ADD wallet.tar.gz /var/oracle
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/app.jar"]
