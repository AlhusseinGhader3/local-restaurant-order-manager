# مرحلة البناء
FROM maven:3.9.2-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# مرحلة التشغيل
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/lrom-ui/target/lrom-ui-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
