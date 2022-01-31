FROM maven:3.5.2-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests


FROM openjdk:11.0.7-jdk-slim
COPY --from=build /usr/src/app/target/testTech.jar /usr/app/testTech.jar 
EXPOSE 8025
ENTRYPOINT ["java","-jar","/usr/app/testTech.jar"]