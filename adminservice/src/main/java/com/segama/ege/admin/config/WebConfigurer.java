package com.segama.ege.admin.config;
import com.segama.ege.admin.intercepter.BaseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(BaseInterceptor()).addPathPatterns("/ege/api/admin/**");
    }

    @Bean
    public BaseInterceptor BaseInterceptor(){
        return new BaseInterceptor();
    }
}
