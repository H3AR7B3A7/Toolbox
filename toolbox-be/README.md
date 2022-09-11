# Toolbox Service

## Service

[Main](http://localhost:8080/toolbox-service/)

[Login](http://localhost:8080/toolbox-service/login)

[Logout](http://localhost:8080/toolbox-service/logout)

## H2 Database

[H2 Console](http://localhost:8080/toolbox-service/h2-console)

username: sa
password:

SELECT * FROM TOOL_PLATFORM_USER

## OpenAPI

[UI](http://localhost:8080/toolbox-service/swagger-ui.html)

[Json](http://localhost:8080/toolbox-service/v3/api-docs)

[Yaml](http://localhost:8080/toolbox-service/v3/api-docs.yaml)

## Tests

### All Tests:

> gradle test

### Unit Tests

> gradle test -PskipIT

or

> gradle unitTest

### Integration Tests

> gradle integrationTest