# docker pull openjdk:18.0.1.1-jdk-buster
#   gradle build
#   docker build --build-arg JAR_FILE=build/libs/\*.jar -t springapp/work-normalian-demo:20220718v2 .
#   docker tag springapp/work-normalian-demo:20220718v2 normalianspringbootacr01.azurecr.io/springapp/work-normalian-demo:20220718v2
#   docker push normalianspringbootacr01.azurecr.io/springapp/work-normalian-demo:20220718v2
#   docker run --name springapp01 -p 8080:80 springapp/work-normalian-demo:20220718v2

FROM openjdk:18.0.1.1-jdk-buster

RUN mkdir /usr/local/app_insights/
RUN wget -O /usr/local/app_insights/applicationinsights-agent-3.3.0.jar https://github.com/microsoft/ApplicationInsights-Java/releases/download/3.3.0/applicationinsights-agent-3.3.0.jar

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar", "--server.port=80", "-javaagent:/usr/local/app_insights/applicationinsights-agent-3.3.0.jar"]
