package com.ricardo.practica2.security;

import com.ricardo.practica2.services.EnglishGreetingService;
import com.ricardo.practica2.services.GreetingService;
import com.ricardo.practica2.services.SpanishGreetingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfiguration {



    @Bean
    @ConditionalOnProperty(value = "language.greeting.service", havingValue = "es")
    public GreetingService spanishGreetingService() {
        return new SpanishGreetingService();
    }

    @Bean
    @ConditionalOnProperty(value = "language.greeting.service", havingValue = "en")
    public GreetingService englishGreetingService() {
        return new EnglishGreetingService();
    }

    @Bean
    @ConditionalOnMissingBean
    public GreetingService defaultGreetingService() {
        return new EnglishGreetingService();
    }

    @Bean feign.Logger.Level feignLoggerLevel() { return feign.Logger.Level.FULL; }

}
