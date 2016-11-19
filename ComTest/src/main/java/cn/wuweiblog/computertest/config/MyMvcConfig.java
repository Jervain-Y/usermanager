package cn.wuweiblog.computertest.config;

import cn.wuweiblog.computertest.intercepter.DuplicateSubmitInterceptor;
import cn.wuweiblog.computertest.intercepter.LoginIntecepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Jervain on 2016-11-17.
 */
@Configuration
@ComponentScan("cn.wuweiblog.computertest")
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Bean
    public DuplicateSubmitInterceptor duplicateSubmitInterceptor() {
        return new DuplicateSubmitInterceptor();
    }

    @Bean
    public LoginIntecepter loginIntecepter() {
        return new LoginIntecepter();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntecepter());
        registry.addInterceptor(duplicateSubmitInterceptor());
    }
}
