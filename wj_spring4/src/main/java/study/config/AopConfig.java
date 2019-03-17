package study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xueshiqi
 * @since 2018/9/13
 */
@Configuration
@ComponentScan("study")
@EnableAspectJAutoProxy//开启对注解的扫描
public class AopConfig {
}
