FROM gradle:8-jdk21 AS build
WORKDIR /app
COPY build.gradle settings.gradle* gradle.* ./
COPY gradle ./gradle
COPY . .
RUN gradle clean bootJar -x test --no-daemon

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ./app.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=prod
CMD ["java", "-jar", "app.jar"]
