package com.subhajit.filters;

import jakarta.servlet.*;
import org.springframework.core.annotation.Order;

import java.io.IOException;

public class FilterOne implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter One starts.................");
        try{
            Thread.sleep(20000);
        }catch(Exception e){}
        chain.doFilter(request, response);
        System.out.println("Filter One ends.................");
    }
}
