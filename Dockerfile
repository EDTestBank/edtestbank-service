FROM openjdk:11
ARG JAR_FILE=edtestbank-service/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]