# spring cloud 云配置中心

## 支持项目进行云配置
+ 云配置中心使用GitHub
+ 集成消息总线 Bus （rabbitMQ）
+ 集成分布式追踪系统 Jaeger
+ 集成 eureka client



## 使用指南
### 配置config server
1. 引入 config server jar
    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
        <version>2.1.1.RELEASE</version>
    </dependency>
    ```

2. 配置 config server
    ```properties
    #config server
    #配置git仓库地址
    spring.cloud.config.server.git.uri=https://github.com/wtf182/spring-config-center.git
    #配置仓库路径
    spring.cloud.config.server.git.searchPaths=project01
    #配置仓库的分支
    spring.cloud.config.label=dev
    #访问git仓库的用户名
    spring.cloud.config.server.git.username=
    #访问git仓库的用户密码
    spring.cloud.config.server.git.password=
    ```

3. 开启 config server\
    `@EnableConfigServer`
    
###配置消息总线，使用rabbitMQ
1. 引入jar
    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        <version>2.1.1.RELEASE</version>
    </dependency>
    ```
2. 配置 MQ 和 消息总线
    ```properties
    #消息总线
    spring.cloud.bus.enabled=true
    spring.cloud.bus.trace.enabled=true
    management.endpoints.web.exposure.include=bus-refresh
    
    # mq
    spring.rabbitmq.host=localhost
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=admin
    spring.rabbitmq.password=admin
    ```
3. 当配置有变更的时候执行一下命令\
    `curl -X POST http://localhost:8080/actuator/bus-refresh`