FROM eclipse-temurin:17-jdk 

ADD build/libs/product-service.jar product-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms64m", "-jar", "product-service.jar"]