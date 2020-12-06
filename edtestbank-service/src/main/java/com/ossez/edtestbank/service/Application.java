package com.ossez.edtestbank.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Spring Application
 */
@EnableScheduling
@EnableCaching
@EnableResourceServer
@SpringBootApplication
@ComponentScan("com.ossez.edtestbank")
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(new RequestContextListener());

    }

    /**
     * Main function for service application
     *
     * @param args
     * @throws Exception
     */
    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class, args);

    }

}
