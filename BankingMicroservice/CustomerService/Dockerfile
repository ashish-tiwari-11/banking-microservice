FROM openjdk:17

COPY target/CustomerService*.jar customerService.jar

ENTRYPOINT ["java","-jar","./customerService.jar"]