package com.yunlu.micro;

import com.yunlu.micro.config.YlExceptionHandlerExceptionResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.ArrayList;
import java.util.List;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@EnableAuthorizationServer
@EnableHystrix
@EnableEurekaClient
public class AlanOAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlanOAuthApplication.class, args);
    }

    @Bean
    MappingJackson2HttpMessageConverter converter() {
        //Set HTTP Message converter using a JSON implementation.
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        // Add supported media type returned by BI API.
        List supportedMediaTypes = new ArrayList();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        jsonMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return jsonMessageConverter;
    }

    @Bean
    public ExceptionHandlerExceptionResolver handlerExceptionResolver() {
        YlExceptionHandlerExceptionResolver exceptionResolver = new YlExceptionHandlerExceptionResolver();
        exceptionResolver.setMessageConverters(messageConverters());
        return exceptionResolver;
    }

    private List<HttpMessageConverter<?>> messageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(converter());
        return messageConverters;
    }
}
