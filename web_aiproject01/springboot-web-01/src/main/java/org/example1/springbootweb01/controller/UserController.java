package org.example1.springbootweb01.controller;

import cn.hutool.core.io.IoUtil;
import org.example1.springbootweb01.pojo.user;
import org.example1.springbootweb01.service.UserService;
import org.example1.springbootweb01.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController//底层用到 这个注解@RespoonseBody 作用：将controller返回值直接作为响应体的数据直接响应；返回值是对象/集合时会被转换成json
/**
 * 用户信息Controller
 * @Controller
 * @ResponseBody
 */
public class UserController {
    /*@RequestMapping("/list")
    public List<user> list() throws  Exception{
        //加载并读取 user.txt 封装到集合中
        //InputStream in = new FileInputStream(new File("D:\\web_ai_learn\\web_aiproject01\\springboot-web-01\\src\\main\\resources\\user.txt"));
        InputStream in =this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines=IoUtil.readLines(in, "UTF-8",new ArrayList<>());
        //解析用户信息 封装为User对象  list集合
        List<user> userlist=lines.stream().map(line->{
            String[] split = line.split(",");
            Integer id=Integer.parseInt(split[0]);
            String username=split[1];
            String password=split[2];
            String name=split[3];
            Integer age=Integer.parseInt(split[4]);
            LocalDateTime updateTime=LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new user(id,username,password,name,age,updateTime);
        }).toList();

        //返回数据 json
        return userlist;
    }*/
    //方式一：进行属性注入  最快 缺点：看不出属性注入的来源 依赖关系  破坏了类的封装性
    @Autowired
    private UserService userService;

    /*//方式二：构造函数注入
    private final UserService userService;
    @Autowired  //如果当前类中只从在一个构造函数中，则@Autowired可以省略
    public UserController(UserService userService) {
        this.userService = userService;
    }*/
    /*//方式三：setter注入
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/


    @RequestMapping("/list")
    public List<user> list() throws  Exception{
        //调用service 获取数据

        List<user> userlist=userService.findAll();

        //返回数据 json
        return userlist;
    }

}
