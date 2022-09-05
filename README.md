# SpringBoot 复习记录
## Idea 环境
### 安装阿里代码规范工具
https://plugins.jetbrains.com/plugin/10046-alibaba-java-coding-guidelines
### 更改默认 java 文档注释中的 `@author`
https://blog.csdn.net/blackcatsmile/article/details/122025443
### Maven 自动导入依赖
https://blog.csdn.net/fittec/article/details/118942425
## SpringBoot 文档学习
### 1. 入门指南
#### 1.1 SpringBoot 介绍
版本发布日志: https://github.com/spring-projects/spring-boot/wiki#release-notes

**优点**:
- 为所有的 Spring 开发提供从根本上更快且可广泛使用的入门体验
- 简化构建配置, 无代码生成, 无需编写 XML
- 内嵌 Web 服务器(如 Tomcat)
- 开箱即用

**缺点**:
- 迭代快, 需要时刻关注变化
- 封装太深, 内部原理复杂, 不容易精通

#### 1.2 时代背景 
##### 1.2.1 微服务
- 微服务是一种架构风格
- 将一个应用拆分为一组小型服务
- 每个服务运行在自己的进程内, 也就是说每个服务可以独立部署和升级
- 服务之间使用轻量级 HTTP 交互
- 服务围绕业务功能拆分
- 可以由全自动部署机制独立部署(K8s)
- 去中心化, 服务自洽。服务可以使用不同的语言和不同的存储技术
##### 1.2.2 分布式
- 远程调用
- 服务发现
- 负载均衡
- 服务容错
- 配置管理
- 服务监控
- 链路追踪
- 日志管理
- 任务调度
- ...

**分布式解决**
- SpringBoot 编写应用
- SpringCloud 互联
- SpringCloud Data Flow 响应式数据流

##### 1.2.3 云原生
原生应用如何上云。Cloud Native

**上云的困难**:
- 服务自愈
- 弹性伸缩
- 服务隔离
- 自动化部署
- 灰度发布(新老服务并存, 然后慢慢移除旧服务)
- 流量治理
- ...

### 2. 开始 SpringBoot
#### 2.1 要求
SpringBoot 2.7.3
Maven 3.5+
Java  1.8+
#### 2.2 创建 POM
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <!-- lookup parent from repository， 里面有一些默认的打包信息和依赖 -->
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.3</version>
        <relativePath/> 
    </parent>
    <groupId>com.xz</groupId>
    <artifactId>springboot-review-records</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-review-records</name>
    <description>springboot-review-records</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!-- web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- 测试 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```
#### 2.3 编写代码
主程序启动类：
```java
@SpringBootApplication
public class SpringbootReviewRecordsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReviewRecordsApplication.class, args);
    }
}
```

```java
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        return "Hello World！你好！";
    }
}
```
`@RestController = @Controller + @ResponseBody` 表示不跳转页面，只返回请求数据。

`@RequestMapping` 和  `@GetMapping @PostMapping` 区别:
- `@GetMapping` 是一个组合注解，是 `@RequestMapping(method = RequestMethod.GET)` 的缩写。
- `@PostMapping` 是一个组合注解，是 `@RequestMapping(method = RequestMethod.POST)` 的缩写。

#### 2.4 测试
访问 http://localhost:8080/hello 即可， 正常的话可以看到 `"Hello World！你好！"`

#### 2.5 简化配置
resources 中创建 `application.yml` 文件，添加 `server.port: 8888`，
然后访问 http://localhost:8888/hello 即可。

更多可以配置的属性参考：https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties

#### 2.6 简化部署
之前已经在 pom.xml 文件中加入了。
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
使用 maven 打包，然后就可以看到本地 target 目录中出现了一个 `springboot-review-records-0.0.1-SNAPSHOT.jar` 包。
用 `java -jar springboot-review-records-0.0.1-SNAPSHOT.jar` 命令可以直接启动应用。
然后通过访问 http://localhost:8888/hello 即可访问。
