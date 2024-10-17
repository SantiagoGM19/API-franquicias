FROM openjdk:17-jdk-alpine
ENV APP_NAME=api \
    APP_DIR=/app \
    APP_PORT=8080
WORKDIR $APP_DIR

COPY build/libs/$APP_NAME-*.jar $APP_DIR/$APP_NAME.jar

EXPOSE $APP_PORT

CMD "java" "-jar" "/app/api.jar"