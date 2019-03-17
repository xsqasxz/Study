package study.service.impl;

import org.springframework.stereotype.Service;
import study.service.FunctionService;

/**
 * 注入bean来使用的类
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
