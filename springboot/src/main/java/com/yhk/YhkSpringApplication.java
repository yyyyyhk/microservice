package com.yhk;


import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class YhkSpringApplication {

    /**
     * run方法的逻辑
     * 我们希望run方法一旦执行完，就能再浏览器中访问到UserController，势必要在run方法中启动tomcat，通过tomcat接收请求
     * SpringMVC中有一个Servlet 非常核心：DispatcherServlet，这个DispatcherServlet需要绑定一个Spring容器，因为DispatcherServlet接收请求后，就会从绑定的Spring容器中找到所匹配的Controller，并执行匹配的方法
     *
     *      1.创建Spring容器
     *      2.创建Tomcat对象
     *      3.生成DispatcherServlet对象，并且和前面创建出来的Spring容器进行绑定
     *      4.讲DispatcherServlet添加到Tomcat中
     *      5.启动Tomcat
     * @param clazz
     */
    public static void run(Class clazz) {
        //1.创建spring容器
        /**
         * 我们创建的是一个AnnotationConfigWebApplicationContext容器，并且把run方法传入进来的class座位容器的配置类
         */
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();

        //
    }
}