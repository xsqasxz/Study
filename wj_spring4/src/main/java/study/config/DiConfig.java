package study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 这里是一个基本的配置类
 * @author xueshiqi
 * @since 2018/9/13
 */
@Configuration//将该类型声明为一个配置类
@ComponentScan("study")//这里配置一下扫描路径， 会扫描对应路径下面的全部的 @Service @Component @Repository @Controller
public class DiConfig {

}
