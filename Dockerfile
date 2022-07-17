# docker pull openjdk:18.0.1.1-jdk-buster
# docker build --build-arg JAR_FILE=build/libs/\*.jar -t springapp/work-normalian-demo:20220717v2 .
#
FROM openjdk:18.0.1.1-jdk-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
