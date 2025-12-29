FROM maven:3.9.4-eclipse-temurin-21-alpine

WORKDIR /app

# Copy Maven wrapper and pom.xml first
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy project source
COPY src ./src

# Run Spring Boot app
CMD ["./mvnw", "spring-boot:run"]



