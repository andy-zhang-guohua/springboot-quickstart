#### 完全采用缺省配置的最简SpringBootApplication Web应用
	
	1.该项目采用 maven 方式;
	2.假设读者已经准备好了 java 7+ 和 maven 环境，并且使其在命令行窗口可用;
	
##### 1. pom.xml
```
<!--这是基于maven的一个spring boot web项目的最小化的项目文件 pom.xml-->
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>andy.tut.springboot</groupId>
    <artifactId>zero</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.8.RELEASE</version>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```
##### 2. 主程序类

```
package andy.tut.springboot.zero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

```
##### 2. Web Controller演示类

```
package andy.tut.springboot.zero.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
```
##### 3. 整个项目的目录结构
```
// 如下所示 :
// 1. 只包含一个程序入口类 Application.java
// 2. 只包含一个Web Controller 类 SampleController.java
// 3. 其他均采用默认值
springboot-tut-zero 
│  
│ pom.xml
│
└─src
    └─main
        └─java
            └─andy
                └─tut
                    └─springboot
                        └─zero
                            │  Application.java
                            │
                            └─web
                                SampleController.java
```

##### 4.项目实际上所依赖的包
```java
// 通过 mvn dependency:tree 我们可以看到该项目的依赖如下(只展示部分), 从此依赖树可以看出，虽然我们
// 在 pom.xml 中只显式依赖了 spring-boot-starter-web , 实际上通过依赖传递隐式导入了
// 许多其他的库
andy.tut.springboot:zero:jar:1.0-SNAPSHOT
\- org.springframework.boot:spring-boot-starter-web:jar:1.5.8.RELEASE:compile
   +- org.springframework.boot:spring-boot-starter:jar:1.5.8.RELEASE:compile
   |  +- org.springframework.boot:spring-boot:jar:1.5.8.RELEASE:compile
   |  +- org.springframework.boot:spring-boot-autoconfigure:jar:1.5.8.RELEASE:compile
   |  +- org.springframework.boot:spring-boot-starter-logging:jar:1.5.8.RELEASE:compile
   |  +- org.springframework:spring-core:jar:4.3.12.RELEASE:compile
   |  \- org.yaml:snakeyaml:jar:1.17:runtime
   +- org.springframework.boot:spring-boot-starter-tomcat:jar:1.5.8.RELEASE:compile
   |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:8.5.23:compile
   |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:8.5.23:compile
   |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:8.5.23:compile
   +- org.hibernate:hibernate-validator:jar:5.3.5.Final:compile
   |  +- javax.validation:validation-api:jar:1.1.0.Final:compile
   |  +- org.jboss.logging:jboss-logging:jar:3.3.1.Final:compile
   |  \- com.fasterxml:classmate:jar:1.3.4:compile
   +- com.fasterxml.jackson.core:jackson-databind:jar:2.8.10:compile
   |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.8.0:compile
   |  \- com.fasterxml.jackson.core:jackson-core:jar:2.8.10:compile
   +- org.springframework:spring-web:jar:4.3.12.RELEASE:compile
   |  +- org.springframework:spring-aop:jar:4.3.12.RELEASE:compile
   |  +- org.springframework:spring-beans:jar:4.3.12.RELEASE:compile
   |  \- org.springframework:spring-context:jar:4.3.12.RELEASE:compile
   \- org.springframework:spring-webmvc:jar:4.3.12.RELEASE:compile
      \- org.springframework:spring-expression:jar:4.3.12.RELEASE:compile
```
##### 5.运行程序
```
// 运行程序
// 1. 在命令行窗口中来到项目根目录 springboot-tut-zero
mvn spring-boot:run
```

可以看到 : 

	1.程序使用8080端口启动了一个内嵌的 tomcat
	2.浏览器访问 http://localhost:8080 , 页面显示文字内容 : Hello World !
		
##### 本项目特点总结
	1. Springboot Web应用
	2. 完全采用缺省配置
	3. 为了更明确展示各自角色的不同，入口主程序类和Web控制器类分开
	4. 使用 mvn spring-boot:run 可以独立运行该程序
	5. mvn package 在 target 目录下打包输出的 zero-1.0-SNAPSHOT.jar 尚不能独立运行(后续会有讲解如何独立运行)
	