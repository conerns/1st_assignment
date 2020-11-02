# Utilizzo image
FROM maven:3.6.3-jdk-11
COPY ./target/pipeline-1.0-SNAPSHOT.jar	./file-pipiline.jar

EXPOSE 3306 3036 8080
ENTRYPOINT ["java", "-jar", "file-pipiline.jar"]

