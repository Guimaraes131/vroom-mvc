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
ENV JAVA_OPTS="-Xms256m -Xmx512m"

CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
