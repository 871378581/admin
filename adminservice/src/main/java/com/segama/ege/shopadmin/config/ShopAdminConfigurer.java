package com.segama.ege.shopadmin.config;
import com.segama.ege.admin.intercepter.BaseInterceptor;
import com.segama.ege.shopadmin.intercepter.ShopAdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ShopAdminConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ShopAdminInterceptor()).addPathPatterns("/ege/api/shop_admin/**");
    }

    @Bean
    public ShopAdminInterceptor ShopAdminInterceptor(){
        return new ShopAdminInterceptor();
    }
}
