package org.example1.springbootweb1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//表示这个类为请求处理类
public class HelloConler {
    @RequestMapping("/hello")//表示这个方法处理/hello请求
    public String hello(String name){//这个形参接受前端传过来的name
        System.out.println("name: "+name);//控制台日志输出
        return "hello "+name;//给前端响应数据
    }
}
