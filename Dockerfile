# Set the base image
FROM openjdk:8-jre-alpine

WORKDIR /app
COPY src /app/src
RUN apk add --no-cache openjdk8
RUN javac -d . src/**/*.java

ENTRYPOINT ["java", "-cp", ".", "program.App"]
