package study.mymain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.config.DiConfig;
import study.service.BeanWayService;
import study.service.UserFunctionService;

/**
 * bean注入例子
 * @author xueshiqi
 * @since 2018/9/13
 */
public class BeanMain {
    public static void main(String[] s){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UserFunctionService userFunctionService = context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("我的世界"));
        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        context.close();
    }
}
