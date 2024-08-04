FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar","-XX:InitialRAMPercentage=10","-XX:MinRAMPercentage=50","-XX:MaxRAMPercentage=90"]