package study.service.impl;

import org.springframework.stereotype.Service;
import study.service.FunctionService;

/**
 * 一个基本例子，我们这里随便声明一个类型来进行处理
 * @author xueshiqi
 * @since 2018/9/13
 */
@Service
public class FunctionServiceImpl implements FunctionService {
    @Override
    public String sayHollo(String word) {
        return "Hollo "+word;
    }
}
