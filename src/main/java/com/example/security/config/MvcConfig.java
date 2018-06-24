package com.example.security.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/index").setViewName("/");
        registry.addViewController("/level1/1.html").setViewName("/level1/1.html");
        registry.addViewController("/level2/2.html").setViewName("/level2/2.html");
        registry.addViewController("/level3/3.html").setViewName("/level3/3.html");

    }
}
