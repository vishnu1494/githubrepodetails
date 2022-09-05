# GitHub Repository Information project with Spring boot application-REST API
-----------------------------------------------------------------------------

This application REST API will return the GitHub Repository information for the given user.

## Technology Used
* OpenJDK 8
* Spring Boot 2.7.3 (with Spring Web MVC)
* Maven 3.6.2
* Swagger UI
* Actuator

## Default Endpoints

| Method | Url | Decription |
| ------ | --- | ---------- |
| GET    |/actuator/health  | Health check endpoint |
| GET    |/swagger-ui/index.html | Swagger information |


## REST API

### getuserrepodetails
--------------------------

This REST API will return the github repository details for the user which passed as request param.

#### Method : GET
#### Url    : /gitrepoinfo/api/v1/getuserrepodetails
#### Params : userid=<<>>

## Note
* This code base contains a `Docker` file which is having a openjdk-1.8 runtime env.
* This code base contains a `ecs` folder which is having task-defenition template for ECS service.
