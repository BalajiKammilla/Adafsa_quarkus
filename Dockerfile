# Use official OpenJDK 17 as the base image
FROM openjdk:17-jdk AS build

# Set working directory in the container
WORKDIR /usr/src/app

# Copy the entire project to the container
COPY . /usr/src/app

# Set working directory to project directory
WORKDIR /usr/src/app
FROM registry.access.redhat.com/ubi8/ubi-minimal
# Build the native image
RUN ./gradlew clean build -Dquarkus.native.container-build=true

# Use Red Hat's UBI minimal base image
FROM registry.access.redhat.com/ubi8/ubi-minimal

# Set working directory in the container
WORKDIR /work/

# Copy the native executable from the builder stage to the final container image
COPY --from=build /usr/src/app/build/*-runner /work/application

# Adjust permissions
RUN chmod 775 /work

# Expose port 8080
EXPOSE 8080

# Set the default command to run the native executable
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]