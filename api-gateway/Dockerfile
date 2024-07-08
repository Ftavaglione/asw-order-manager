FROM eclipse-temurin:17-jdk

ADD build/libs/api-gateway.jar api-gateway.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms64m", "-jar", "api-gateway.jar"]