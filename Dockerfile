FROM openjdk:19

COPY target/jira-1.0.jar ./jira-1.0.jar
COPY resources ./resources
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/jira-1.0.jar"]
