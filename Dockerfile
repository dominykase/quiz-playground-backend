FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . /app
RUN apk add --no-cache maven
RUN mvn clean install -DskipTests
EXPOSE 8090
CMD ["mvn", "spring-boot:run"]
