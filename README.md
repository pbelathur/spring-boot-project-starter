# Spring Boot Starter Project

### Purpose
A _ready to use_ web application based on Spring Boot v2.2.4.  
This application contains the following:
* Spring Boot actuator, devtools and web starters.
* Lombok dependency and annotation processing.
* Actuator endpoints for info, health and metrics.
* Enabled junit5 and explicit exclusion of junit4.
* DB2, Oracle and H2 database driver dependencies
* Inclusion of GIT properties in actuator _info_ endpoint 

# Getting Started
1. Clone this repo from the Github
2. Open a command window and navigate to `spring-boot-project-starter` directory
3. `./gradlew build bootRun`
4. Verify the spring boot application is running using actuator healthcheck endpoint `http://localhost:8080/actuator/health`

## Deploy to Cloud Foundry
1. open a command window and navigate to `spring-boot-project-starter` directory
2. `./gradlew clean bootJar`
3. verify `build/libs/spring-boot-project-starter.jar` exists
4. `cf push`
