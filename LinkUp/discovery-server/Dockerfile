# FROM maven:3.9.4-eclipse-temurin-21-alpine

# WORKDIR /app

# # Copy Maven wrapper and pom.xml first
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
# RUN chmod +x mvnw && ./mvnw dependency:go-offline

# # Copy project source
# COPY src ./src

# # Run Spring Boot app
# CMD ["./mvnw", "spring-boot:run"]





FROM maven:3.9.4-eclipse-temurin-21-alpine

WORKDIR /app

# Copy pom.xml first to leverage Docker cache
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy project source (including .mvn and wrapper if needed)
COPY .mvn/ .mvn
COPY mvnw ./
COPY src ./src

# Run Spring Boot app
CMD ["mvn", "spring-boot:run"]
