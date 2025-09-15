package org.example1.springbootweb01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
//实体类
@Data//getter setter
@NoArgsConstructor
@AllArgsConstructor//全参构造
public class user {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;


}
