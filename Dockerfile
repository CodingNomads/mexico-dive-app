FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ENV JAR_FILE dive-app-0.0.1.jar
ARG JAR_PATH='build/libs/'${JAR_FILE}
COPY ${JAR_PATH} ${JAR_FILE}
ENTRYPOINT java -jar /$JAR_FILE
