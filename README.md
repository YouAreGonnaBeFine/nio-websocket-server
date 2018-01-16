WebSocket Server
===============

## Summary
A high performance websocket server base on [SpringBoot](https://projects.spring.io/spring-boot/)   and [Netty](http://netty.io/).  

## Usage
### You require the following to run the program:
* [Oracle JDK 8](https://www.oracle.com/java/technologies/java-se.html)
* [Apache Maven](http://maven.apache.org/)
* [RabbitMQ](http://www.rabbitmq.com/)

### Edit the application.properties file
The location is `/athena-s-alpha/src/main/resources/application.properties`.

### Build Java code
Run `mvn package`.
## Performance
A aliyun ECS with 4G memory can support 60k connections.
## License
    Copyright 2018 YangGuo
    MIT License
