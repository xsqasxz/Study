package study.service.impl;

import org.springframework.stereotype.Service;
import study.annotation.MyAction;
import study.service.DemoAnnotationService;

/**
 * 此类用于使用注解来创建的类型 aspectjrt
 * @author xueshiqi
 * @since 2018/9/13
 */
@Service
public class DemoMethodServiceImpl implements DemoAnnotationService {

    @MyAction(name = "注解式拦截的add操作")
    @Override
    public void add() {
    }
}
