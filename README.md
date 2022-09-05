# GitHub Repository Information project with Spring boot application-REST API
===================================================================================

This application REST API will return the GitHub Repository information for the given user.


### Default Endpoints

| Method | Url | Decription |
| ------ | --- | ---------- |
| GET    |/actuator/health  | Health check endpoint |
| GET    |/swagger-ui/index.html | Swagger information |


### REST API

1) getuserrepodetails
--------------------------

This REST API will return the github repository details for the user which passed as request param.

Method : GET
Url    : /gitrepoinfo/api/v1/getuserrepodetails
Params : userid=<<>>

