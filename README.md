# web1daima

Spring Boot Web 学习示例项目（Java + Spring Boot 3），包含三个独立的 Maven 模块，从 Maven 基础、Spring MVC 请求/响应处理，一步步走到 **Controller - Service - Dao 三层架构 + IoC/DI**，最后用一个 **Vue 3 + Axios** 页面把用户列表接口展示出来。

项目代码中保留了详细的中文注释，适合作为 Spring Boot Web 入门的练习与参考。

## 功能特性

- 📋 用户列表查询接口，返回 JSON 数据
- 🖥️ 基于 Vue 3 + Axios 的用户列表页面（表格展示）
- 🔍 使用 `HttpServletRequest` 获取请求方式、URL、协议、参数、请求头
- 📤 两种设置响应数据的方式：`HttpServletResponse` 与 `ResponseEntity`
- 🧩 三层架构（Controller / Service / Dao）拆分示例
- 💉 属性注入、构造器注入、Setter 注入三种依赖注入写法
- 📦 Maven 依赖配置、依赖排除（`exclusion`）示例

## 技术栈

| 分类 | 技术 |
| --- | --- |
| 语言 | Java 17 / 21 |
| 框架 | Spring Boot 3.5.5（Spring MVC） |
| 构建工具 | Maven |
| 工具库 | Lombok、Hutool 5.8.27 |
| 监控 | Spring Boot Actuator |
| 前端 | Vue 3（ESM 浏览器构建）+ Axios（本地静态文件引入） |
| 测试 | JUnit 5 |

## 项目结构

```
web1daima/
└── web_aiproject01/                     # IntelliJ IDEA 工程目录
    ├── maven-project01/                 # ① Maven 基础示例
    │   ├── pom.xml                      #    依赖配置 / 依赖排除
    │   └── src/main/java/com/exampl1/HelloWorld.java
    │
    ├── springboot-web1/                 # ② Spring MVC 请求与响应
    │   ├── pom.xml
    │   └── src/main/
    │       ├── java/org/example1/springbootweb1/
    │       │   ├── SpringbootWeb1Application.java   # 启动类
    │       │   ├── HelloConler.java                 # /hello 入门示例
    │       │   ├── RequestController.java           # 获取请求数据
    │       │   └── ResponseController.java          # 设置响应数据
    │       └── resources/application.properties
    │
    └── springboot-web-01/               # ③ 三层架构 + 用户列表
        ├── pom.xml
        └── src/main/
            ├── java/org/example1/springbootweb01/
            │   ├── SpringbootWeb01Application.java  # 启动类
            │   ├── controller/UserController.java   # 控制层
            │   ├── service/UserService.java         # 服务层接口
            │   ├── service/impl/UserServiceimpl.java
            │   ├── dao/UserDao.java                 # 数据访问层接口
            │   ├── dao/impl/UserDaoimpl.java
            │   └── pojo/user.java                   # 实体类
            └── resources/
                ├── application.properties
                ├── user.txt                         # 用户数据（逗号分隔）
                └── static/
                    ├── user.html                    # 用户列表页面
                    └── js/                          # vue.esm-browser.js、axios.min.js
```

## 环境要求

- **JDK 21**（`maven-project01` 的编译级别为 21；两个 Spring Boot 模块为 17，JDK 21 可向下兼容）
- **Maven 3.6.3+**
- 无需数据库，用户数据直接读取 `resources/user.txt`

## 快速开始

### 方式一：命令行运行

```bash
# 进入仓库中的工程目录
cd web_aiproject01

# 启动「Spring MVC 请求/响应」示例
mvn -f springboot-web1/pom.xml spring-boot:run

# 启动「三层架构 + 用户列表」示例
mvn -f springboot-web-01/pom.xml spring-boot:run
```

> 两个 Web 模块默认端口都是 `8080`，如需同时运行，请修改其中一个模块的 `application.properties`：
>
> ```properties
> server.port=8081
> ```

### 方式二：打包后运行

```bash
mvn -f springboot-web-01/pom.xml clean package
java -jar springboot-web-01/target/springboot-web-01-0.0.1-SNAPSHOT.jar
```

### 方式三：IntelliJ IDEA

1. 用 IDEA 打开 `web_aiproject01` 目录（或将三个模块分别导入为 Maven 项目）；
2. 等待 Maven 依赖下载完成；
3. 打开对应模块的启动类（`SpringbootWeb1Application` / `SpringbootWeb01Application`），点击运行；
4. 浏览器访问下方接口即可。

## 接口说明

### springboot-web1（请求 / 响应示例，默认端口 8080）

| 方法 | 路径 | 参数 | 说明 |
| --- | --- | --- | --- |
| GET | `/hello` | `name` | 返回 `hello {name}` |
| GET | `/request` | `name`、`age` | 解析并打印请求方式、URL、协议、参数、请求头，返回固定字符串 |
| GET | `/response` | - | 通过 `HttpServletResponse` 设置状态码、响应头与响应体 |
| GET | `/response2` | - | 通过 `ResponseEntity` 设置状态码、响应头与响应体 |

示例：

```bash
curl "http://localhost:8080/hello?name=spl"
# hello spl

curl -i "http://localhost:8080/response"
# HTTP/1.1 200
# name: spl
# hello world
```

### springboot-web-01（用户列表，默认端口 8080）

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| GET | `/list` | 查询全部用户，返回 JSON 数组 |
| GET | `/user.html` | 用户列表页面（Vue + Axios 调用 `/list`） |

示例响应：

```json
[
  {
    "id": 1,
    "username": "daqiao",
    "password": "1234567890",
    "name": "大乔",
    "age": 22,
    "updateTime": "2024-07-15T15:05:45"
  }
]
```

## 数据说明

用户数据保存在 `springboot-web-01/src/main/resources/user.txt`，每行一条记录，字段以英文逗号分隔：

```
id,username,password,name,age,updateTime
1,daqiao,1234567890,大乔,22,2024-07-15 15:05:45
```

`UserDaoimpl` 通过 `ClassLoader.getResourceAsStream("user.txt")` 读取 classpath 下的文件，`UserServiceimpl` 负责把每行解析并封装成 `user` 对象。

## 注意事项

- 两个 Web 模块默认端口均为 `8080`，同时启动会端口冲突，需手动修改 `server.port`。
- 用户密码为明文演示数据，仅用于学习，请勿用于生产环境。
- 仓库中提交了 `target/` 编译产物与 `.idea/` 目录，建议添加 `.gitignore` 后再提交，保持仓库整洁。
- 当前项目没有接入数据库和持久层框架，数据来源为本地文本文件。
- 实体类名为 `user`（小写），为示例写法；实际项目中建议遵循 `User` 的命名规范。

## 后续可扩展方向

- 接入 MyBatis / MyBatis-Plus + MySQL，替换文本文件数据源
- 增加新增、修改、删除用户接口（CRUD）
- 参数校验（`@Valid`）与全局异常处理（`@RestControllerAdvice`）
- 分页查询与统一响应体封装
- 集成 Swagger / Knife4j 生成接口文档
- 前端抽离为 Vue 3 + Vite 独立工程

## 许可证

本项目仅用于学习与交流，未指定开源许可证。
