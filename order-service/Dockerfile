FROM eclipse-temurin:17-jdk 

ADD build/libs/order-service.jar order-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms64m", "-jar", "order-service.jar"]