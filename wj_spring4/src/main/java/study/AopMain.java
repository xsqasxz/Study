package study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.config.AopConfig;
import study.service.DemoAnnotationService;

/**
 * @author xueshiqi
 * @since 2018/9/13
 */
public class AopMain {
    public static void main(String [] s){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        demoAnnotationService.add();
        context.close();
    }
}
