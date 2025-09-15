package org.example1.springbootweb01.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.example1.springbootweb01.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//@Component//将当前类交给容器管理
@Repository//标注数据访问层类上  将当前类交给容器管理    声明bean时候 可以通过 value属性指定bean的id 如果没有指定 则默认为当前类名首字母小写
public class UserDaoimpl implements UserDao {//impl 表示实现类
    @Override
    public List<String> findAll() {
        //加载并读取 user.txt 封装到集合中
        //InputStream in = new FileInputStream(new File("D:\\web_ai_learn\\web_aiproject01\\springboot-web-01\\src\\main\\resources\\user.txt"));
        InputStream in =this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines= IoUtil.readLines(in, "UTF-8",new ArrayList<>());
        return lines;
    }
}
