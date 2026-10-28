FROM eclipse-temurin:21-jre-noble
WORKDIR /app
COPY target/devops-pbl-lab-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-cp", "app.jar", "HelloWorld"]
