# tomato-architecture-spring-boot-demo
A sample Spring Boot application following [Tomato Architecture](https://github.com/sivaprasadreddy/tomato-architecture)

## Prerequisites
* JDK 21
* Docker Compose

## TechStack
* Java 21
* Spring Boot
* Spring Modulith
* jOOQ
* PostgreSQL
* Kafka
* Testcontainers
* Docker Compose

## How to run?
The application is configured to use Docker Compose to start the dependent services (Postgres, Kafka).
You can simply run `BookStoreApplication.java` from your IDE to start the application.

**NOTE:** To work with Kafka transparently from both local and container, add `127.0.0.1   broker` entry in `/etc/hosts` file.

To know more about Spring Boot Docker Compose Support, you can watch the following video.

[![Spring Boot Docker Compose Support](https://img.youtube.com/vi/PZt5EJTLH4o/0.jpg)](https://www.youtube.com/watch?v=PZt5EJTLH4o)

You can also start the application from commandline as follows:

```shell
$ ./mvnw spring-boot:run
```

## Run tests
You can run the tests as follows:

```shell
$ ./mvnw test
```

The application is using Spring Modulith to verify the module boundaries.
To know more about Spring Modulith, you can watch the following video.

[![Spring Modulith Crash Course : Building Modular Monoliths using Spring Boot](https://img.youtube.com/vi/FkP2aZiBrhg/0.jpg)](https://www.youtube.com/watch?v=FkP2aZiBrhg)

