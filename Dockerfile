# Utilizzo image
FROM 3.6.3-jdk-11
WORKDIR /usr/app
COPY ./target/pipeline-1.0-SNAPSHOT.jar	./file-pipiline.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "file-pipiline.jar"]

