# First stage: Build the application
FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Second stage: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]