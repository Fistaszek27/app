FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /var/build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre

RUN groupadd -r tda_user && useradd -r -g tda_user tda_user

WORKDIR /app
COPY --from=build --chown=tda_user:tda_user /var/build/target/*.jar app.jar

ENV PORT=3001
EXPOSE 3001

USER tda_user
ENTRYPOINT ["java", "-jar", "/app/app.jar"]