FROM openjdk:11.0.7-jdk-slim
VOLUME /tmp
ADD target/testTech /usr/share/test/app.jar
ENTRYPOINT [ "java", "-jar", "/usr/share/test/app.jar" ]
EXPOSE 8025

