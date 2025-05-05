# Dockerfile for bakaneto-backend-topics (with debugging ls command)

# Use a Maven image to build the application
FROM maven:3.9-eclipse-temurin-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY pom.xml .

# Download all dependencies (this step is cached if pom.xml doesn't change)
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src/ ./src/

# Build the application, skipping tests
RUN mvn package -DskipTests

# --- Debugging Step: List the contents of the target directory ---
RUN echo "--- Contents of /app/target ---" && ls -l /app/target && echo "--- End of /app/target contents ---"

# -----------------------------------------------------
# Use Java runtime as a base image for the final image
FROM eclipse-temurin:17-jre-jammy

# Install libaio required by Oracle client libraries
RUN apt-get update && \
    apt-get install -y --no-install-recommends libaio1 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Set TNS_ADMIN environment variable (Wallet mounted via podman-kube.yaml)
ENV TNS_ADMIN=/app/wallet

# Copy the application JAR file from the build stage
# This is the step that was failing
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]