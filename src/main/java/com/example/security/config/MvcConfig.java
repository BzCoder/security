package com.example.security.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
//        registry.addViewController("/index").setViewName("/");
//        registry.addViewController("/level1/1.html").setViewName("/1");
//        registry.addViewController("/level2/2.html").setViewName("/2");
//        registry.addViewController("/level3/3.html").setViewName("/3");

    }
}
