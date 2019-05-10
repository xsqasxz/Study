package com.basics.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author xueshiqi
 * @since 2019/4/3
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfig.class);
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        LOGGER.info(String.valueOf(registry));
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info(String.valueOf(registry));
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }
}
