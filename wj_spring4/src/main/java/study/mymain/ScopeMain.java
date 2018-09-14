package study.mymain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.config.DiConfig;
import study.service.DemoPrototypeService;
import study.service.DemoSingletonService;

/**
 * Scope的例子
 * @author xueshiqi
 * @since 2018/9/14
 */
public class ScopeMain {

    public static void main(String... s){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        DemoSingletonService singletonService1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService singletonService2 = context.getBean(DemoSingletonService.class);
        DemoPrototypeService demoPrototypeService1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService demoPrototypeService2 = context.getBean(DemoPrototypeService.class);
        System.out.println("Sing是否相等"+ singletonService1.equals(singletonService2));
        System.out.println("Prototype是否相等"+ demoPrototypeService1.equals(demoPrototypeService2));
        context.close();
    }
}
