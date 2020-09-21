FROM openjdk:11
EXPOSE 8181
ADD target/spring-boot-demo.jar spring-boot-demo.jar
ENTRYPOINT ["java","-jar","/spring-boot-demo.jar"]