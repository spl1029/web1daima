package org.example1.springbootweb1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request") //请求路径
    public String request(HttpServletRequest request) {
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println("method:" + method);// GET
        //2.获取请求url
        String url = request.getRequestURL().toString();
        System.out.println("url:" + url);// http://localhost:8080/request
        String requesturi  =request.getRequestURI();
        System.out.println("requesturi:" + requesturi);// /request 资源的访问路径
        //3.获取请求协议
        String protocol = request.getProtocol();
        System.out.println("protocol:" + protocol);// HTTP/1.1
        //4.获取请求参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name:" + name); //name=spl
        System.out.println("age:" + age);
        //5.获取请求头-Accept
        String accept = request.getHeader("Accept");//获取指定名字请求头的 内容
        System.out.println("Accept:" + accept);
        return "RequestController";
    }
}
