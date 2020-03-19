package com.pyfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Auditing {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}
