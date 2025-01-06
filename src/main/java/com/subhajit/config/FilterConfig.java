package com.subhajit.config;

import com.subhajit.filters.FilterOne;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

   // @Bean
    public FilterRegistrationBean<FilterOne> filterOne(){
        FilterRegistrationBean<FilterOne> filterOneRegistrationBean
                = new FilterRegistrationBean<>();

        filterOneRegistrationBean.setFilter(new FilterOne());
        filterOneRegistrationBean.addUrlPatterns("/connection-timeout");

        return filterOneRegistrationBean;
    }

}
