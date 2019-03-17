package study.mymain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.config.DiConfig;
import study.event.DemoPublisher;

/**
 * @author xueshiqi
 * @since 2018/9/14
 */
public class EventMain {

    public static void main(String... s){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("hello application event");
        context.close();
    }
}
