package study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.config.DiConfig;
import study.service.UserFunctionService;

/**
 * @author xueshiqi
 * @since 2018/9/13
 */
public class Main {
    public static void main(String[] s){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UserFunctionService userFunctionService = context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("我的世界"));
        context.close();
    }
}
