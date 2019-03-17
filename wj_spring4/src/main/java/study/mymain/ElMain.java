package study.mymain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.config.ElConfig;

/**
 * EL表达式的使用
 * @author xueshiqi
 * @since 2018/9/14
 */
public class ElMain {
    public static void main(String ... s){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.outoputResource();
        context.close();
    }
}
