FROM openjdk:17-ea-jdk-oracle
COPY target/in-memory-activemq-0.0.1-SNAPSHOT.jar in-memory-activemq.jar
ENTRYPOINT ["java","-jar","/in-memory-activemq.jar"]

