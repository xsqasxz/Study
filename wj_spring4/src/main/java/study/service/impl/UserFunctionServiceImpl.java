package study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.service.FunctionService;
import study.service.UserFunctionService;

/**
 * 写的注入的例子，这里我们使用注解对 functionService进行注入
 * @author xueshiqi
 * @since 2018/9/13
 */
@Service
public class UserFunctionServiceImpl implements UserFunctionService {
    @Autowired
    FunctionService functionService;

    @Override
    public String sayHello(String word) {
        return functionService.sayHollo(word);
    }
}
