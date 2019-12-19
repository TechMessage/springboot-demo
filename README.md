# Getting Started

### pom.xml解构

- 继承父pom
```
    <!--  继承父pom工程的配置信息  -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.2.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    父pom的特性
    1. jdk1.8 默认编译环境
    2. UTF-8编码
    3. 感知加载资源文件 application*.properties|yml 文件, 推荐.yml文件格式，跨平台且内容布局清晰。
    4. 继承父pom是推荐做法，可以自己手动书写所有配置
```

- stater -- 是某个技术栈所有依赖包的集合
```
    1. stater 其实包含了一系列的依赖组合
    2. 官方的stater命名方式： spring-boot-starter-*, 例如 spring-boot-starter-aop
   
    
```



### springboot 项目目录结构
```
com
    +- example
        +- myapplication
            +- Application.java
            |
            +- customer
                | +- Customer.java
                | +- CustomerController.java
                | +- CustomerService.java
                | +- CustomerRepository.java
            |
            +- order
                +- Order.java
                +- OrderController.java
                +- OrderService.java
                +- OrderRepository.java

    1. 项目包路径 com.example.myapplication
    2. Application.java是项目的启动类，位于项目包根路径下
    
    // Application.java
    package com.example.myapplication;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }

```

- 注解 SpringBootApplication
```
1. 该注解其实包含了 SpringBootConfiguration、EnableAutoConfiguration、ComponentScan 三个注解
2. SpringBootConfiguration 注解，表示该类是一个配置类，springboot 倾向于给予Java类的方式来配置项目的信息，原来基于.xml配置的方式都通过java类的方式实现
3. EnableAutoConfiguration 表明，该项目开启springboot的自动默认配置，springboot根据依赖jar包，自动加载默认配置信息。
4. ComponentScan 表明spring容器扫描的默认包路径，所以一般放到项目包的根路径，这样就扫描了项目所有的.java文件，自动注入spring容器中。

SpringBootApplication ----> 一石三鸟 

```


### 开发配置
- spring-boot-devtools

```
    1. springboot项目的依赖，提升开发体验

    ## 特性
    1. 热加载，代码修改，自动重启项目
    2. 感知加载开发环境的配置，例如 模板引擎开启缓存
    3. 对于特定的资源文件修改，不会触发重启，而是重载资源文件。 /resources 

    ## 使用
    1. pom.xml添加依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>

```

- 自定义banner
```
    1. springboot 项目启动时，控制台输入banner可以自定义需改
    2. banner.txt 放到resources根目录下, 可用一些预定义的变量，${ xxx } 取值。
    3. 项目相关的描述在 MANIFEST.MF文件
```

- yml配置信息的暴露

```
    1. 项目的配置文件 *.yml中配置的信息，可以转为属性值，通过@Valvue注解的方式获取值, ${xxx}的方式。
    2. 多环境的配置信息

        server:
        address: 192.168.1.100
        ---
        spring:
        profiles: development
        server:
        address: 127.0.0.1
        ---
        spring:
        profiles: production & eu-central
        server:
        address: 192.168.1.120
       
    
    
```

