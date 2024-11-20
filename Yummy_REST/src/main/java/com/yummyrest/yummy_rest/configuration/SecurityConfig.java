package com.yummyrest.yummy_rest.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
//public class SecurityConfig implements WebMvcConfigurer {
//    privat final RequestInterceptor requestInterceptor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(requestInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/api/v1/auth/**")
//                .excludePathPatterns("/api/v1/customer/**");
//    }
//
//
//    @Bean
//    public PasswordEncoder PasswordEncoder() {
//        //return new BCryptPasswordEncoder();
//        return new Argon2PasswordEncoder(16,32,1,16*1024,4);
//    }
//}

public class SecurityConfig{

    @Bean
    public PasswordEncoder PasswordEncoder() {
        //return new BCryptPasswordEncoder();
        return new Argon2PasswordEncoder(16,32,1,16*1024,4);
    }
}
