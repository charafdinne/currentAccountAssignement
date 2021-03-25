FROM openjdk:11
MAINTAINER charafeddine.boughriba
COPY ../target/CurrentAccountAssignement-0.0.1.jar CurrentAccountAssignement-0.0.1.jar
ENTRYPOINT ["java","-jar","/CurrentAccountAssignement-0.0.1.jar"]