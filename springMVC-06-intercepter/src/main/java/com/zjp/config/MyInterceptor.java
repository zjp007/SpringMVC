package com.zjp.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 拦截器是AOP思想的的体验
// 可以使用切面实现
public class MyInterceptor implements HandlerInterceptor {

    @Override
    // return false      不执行下一个拦截器;
    // return true      执行下一个拦截器,放行;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("==============处理前=================");

        if(request.getRequestURI().indexOf("t2") != -1
                || request.getRequestURI().indexOf("t3") != -1){
            return true;
        }

        if("admin".equals(request.getSession().getAttribute("userId"))){
            return true;
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("==============处理后=================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("==============清理=================");
    }
}
