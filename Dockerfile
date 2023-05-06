FROM openjdk:8-jdk-alpine
ADD practice-0.0.2-SNAPSHOT.jar app.jar
COPY Wallet_DB202106251948 /var/oracle/wallet
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/app.jar"]
