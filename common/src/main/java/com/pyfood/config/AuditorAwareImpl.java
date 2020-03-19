package com.pyfood.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author vmdat
 * @create 19/03/2020
 */
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
