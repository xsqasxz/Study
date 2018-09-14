package study.service.impl;

import org.springframework.stereotype.Service;
import study.service.BeanWayService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 对Bean的初始化和销毁
 * @author xueshiqi
 * @since 2018/9/14
 */
@Service
public class BeanWayServiceImpl implements BeanWayService {
    public BeanWayServiceImpl() {
        System.out.println("初始化BeanWayServiceImpl");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化前面BeanWayServiceImpl");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁后调用初始化BeanWayServiceImpl");
    }
}
