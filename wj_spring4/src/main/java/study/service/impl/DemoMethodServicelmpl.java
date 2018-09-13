package study.service.impl;

import org.springframework.stereotype.Service;
import study.annotation.Action;
import study.service.DemoAnnotationService;

/**
 * @author xueshiqi
 * @since 2018/9/13
 */
@Service
public class DemoMethodServicelmpl implements DemoAnnotationService {
    @Action(name = "注解式拦截的add操作")
    @Override
    public void add() {

    }
}
