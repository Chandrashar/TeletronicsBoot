FROM openjdk:8-jre
LABEL maintainer="chandrashar@gmail.com"
ARG JAR_FILE=target/TeletronicsBoot-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} TeletronicsBoot.jar
RUN bash -c 'touch /TeletronicsBoot.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/TeletronicsBoot.jar"]
EXPOSE 80:8080