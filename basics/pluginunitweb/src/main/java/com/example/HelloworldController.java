package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Controller 是Spring MVC 注解，表示此类用于负责处理Web请求。
 * @RequestMapping 是Strping MVC  注解， 表示如果请求路径匹配吗，被注解的方法将被调用。
 * @ResponseBody 表示此方法返回的是文本而不是视图名称。
 */
@Controller
public class HelloworldController {

    @RequestMapping("/login.html")
    public String  login(){
        return "/login";
    }

    @RequestMapping("/sayhello.html")
    public @ResponseBody String say(){
        return "Holle Spring Boot";
    }

    @RequestMapping("/index.html")
    public String  index(){
        return "/index";
    }

    @RequestMapping("/blog.html")
    public String  blog(){
        return "/blog";
    }

    @RequestMapping("/sidebar.html")
    public String  sidebar(){
        return "/sidebar";
    }
}
