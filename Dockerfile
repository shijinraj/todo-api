FROM openjdk:21-jdk-slim
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/todo-api-0.0.1-SNAPSHOT.jar"]