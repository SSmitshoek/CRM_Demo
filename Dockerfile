# First stage: build the Maven project
FROM maven:3.8.3-openjdk-17 as builder

# Set the working directory in the builder container
WORKDIR /build

# Copy the pom.xml file into the builder container
COPY pom.xml .

# Download dependencies for caching
RUN mvn dependency:go-offline

# Copy the source code into the builder container
COPY src src

# Build the project and generate the JAR file
RUN mvn clean package -DskipTests

# Second stage: create the final image with the JRE
FROM eclipse-temurin:17-jre-alpine

# Set the working directory in the final container
WORKDIR /app

# Copy the JAR file from the builder container to the working directory in the final container
COPY --from=builder /build/target/*.jar CRMDemoApplication.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the JAR file as a Spring Boot application
ENTRYPOINT ["java", "-jar", "CRMDemoApplication.jar"]