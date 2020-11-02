# Utilizzo image
FROM openjdk:11-jdk-slim
RUN apt-get update && apt-get install -y curl

COPY ./target/pipeline-1.0-SNAPSHOT.jar	./file-pipiline.jar

EXPOSE 3306 3036 8080
ENTRYPOINT ["java", "-jar", "file-pipiline.jar"]

