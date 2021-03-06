# Coin Calculation

Calculates coins according to the parameters it takes as inputs

## Authors

- [@sevim demir](https://github.com/sevimdemir)


## API Reference

#### Get all available coins

```http
  GET /api/v1/coin
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

#### Get all available currency

```http
  GET /api/v1/currency
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |


#### Get coin calculation

```http
  GET /api/items/${currency}${amount}${coin}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `currency` | `string` | **Required**. Your currency type |
| `coin`     | `string` | **Required**. Your coin type |
| `amount`   | `numbers`| **Required**. Your amount |


## Deployment

#### Build Java Jar
At the project base directory run:
```
$ mvnw.cmd clean install 
```

#### Docker Compose Build and Run
```
$ docker-compose build --no-cache
$ docker-compose up --force-recreate
```
Endpoints with Swagger

You can see the endpoint in http://localhost:8080/swagger-ui/index.html page.
## Requirements

- Java 11

- Docker


## Used Technologies

- Java 11

- Spring-Boot

- PostgreSql

- Maven

- Docker

- Redis

- Swagger

- Mockito