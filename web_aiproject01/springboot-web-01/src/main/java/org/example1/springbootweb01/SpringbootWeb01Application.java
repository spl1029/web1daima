package org.example1.springbootweb01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//三层架构：controller控制层、接受前端发送的请求，对请求进行处理，返回结果给前端
// service服务层、处理具体的业务逻辑
// Dao数据访问层 负责数据访问操作
//层与层解耦   控制反转 （IOC）：对象的创建控制权转换 放入容器  依赖注入（DI）：容器为程序提供依赖的资源  对象的创建和依赖注入   Bean 对象 IOC容器管理的对象
//将对象交给容器管理 @Component   注入依赖的管理 @Autowired  自动从容器中找到对应的对象
/*前面声明bean的四大注解，要想生效，还需要被组件扫描注解  @ComponentScan
扫描该注解虽然没有显式配置，但是实际上已经包含在了启动类声明注解 @SpringBootApplication 中，
默认扫描的范围是启动类所在包及其子包*/
@SpringBootApplication
public class SpringbootWeb01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb01Application.class, args);
    }

}
