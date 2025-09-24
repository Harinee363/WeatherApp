FROM openjdk:26-jdk
ADD target/weather-App.jar weather-App.jar
ENTRYPOINT ["java","-jar","/weather-App.jar"]
