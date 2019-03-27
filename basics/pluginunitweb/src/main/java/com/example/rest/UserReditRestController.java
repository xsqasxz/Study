package com.example.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里使用了 @RestController 而不是使用 @Controller ， 方法也没用使用 @ResponseBody注解。
 * 可以理解为@RestController相当于@Controller和@ResponseBody。
 */
@RestController
public class UserReditRestController {

    @RequestMapping(value = "/usercredit/{id}")
    public Integer getCreditLevel(@PathVariable String id){
        //传入id模拟返回id转换后的值
        return Integer.valueOf(id);
    }

}
