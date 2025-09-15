package org.example1.springbootweb01.service.impl;

import org.example1.springbootweb01.dao.UserDao;
import org.example1.springbootweb01.dao.impl.UserDaoimpl;
import org.example1.springbootweb01.pojo.user;
import org.example1.springbootweb01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
//@Component
@Primary // 表示这个类是默认的  提高优先级 注入这个优先级高
@Service // 标注业务逻辑层类  交给容器管理        //底层封装了 @Component
public class UserServiceimpl implements UserService {
    @Autowired//应用程序运行时，会自动找UserDaoimpl类，并创建对象，并赋值给userDao属性
    private UserDao userDao ;
    @Override
    public List<user> findAll() {
        //调用dao获取数据
        List<String> lines = userDao.findAll();
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
        return userlist;
    }
}
