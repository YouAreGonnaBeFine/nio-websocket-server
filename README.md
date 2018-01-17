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
A aliyun ECS with 4GB memory can support 60k connections.
## License
MIT License

Copyright (c) [2018] [Yang Guo]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
