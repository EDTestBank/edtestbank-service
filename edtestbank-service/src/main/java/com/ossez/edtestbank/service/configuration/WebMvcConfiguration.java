package com.ossez.edtestbank.service.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * WebMvcConfiguration to filter user token
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);
//
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
//    }
//
//    @Override
//    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        for (HttpMessageConverter<?> converter : converters) {
//
//            // Fix controller txt
//            if (converter instanceof StringHttpMessageConverter) {
//                ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
//            }
//            // Fix Controller JSON
//            if (converter instanceof MappingJackson2HttpMessageConverter) {
//                ((MappingJackson2HttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
//            }
//        }
//    }
}
