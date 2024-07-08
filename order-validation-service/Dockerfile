FROM eclipse-temurin:17-jdk 

ADD build/libs/order-validation-service.jar order-validation-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms64m", "-jar", "order-validation-service.jar"]