package org.example1.springbootweb1;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
//响应头响应状态码通常情况不设置
@RestController
public class ResponseController {
    /**
     * 通过HttpServletResponse 设置响应数据
     * @param response
     * @throws IOException
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //设置响应状态码
        response.setStatus(200);
        //设置响应头
        response.setHeader("name", "spl");
        //设置响应体
        response.getWriter().write("hello world");

    }
    /**
     * 通过ResponseEntity设置响应数据
     * @return
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(){
        //设置响应状态码
        int statusCode = HttpStatus.OK.value();
        //设置响应头
          HttpHeaders headers = new HttpHeaders();
        headers.add("name", "spl");
        //设置响应体
        String body = "hello world";
        //返回响应对象
        return new ResponseEntity<>(body, headers, statusCode);
//        return ResponseEntity.status(200).header("name", "spl").body("hello world");
    }
}
