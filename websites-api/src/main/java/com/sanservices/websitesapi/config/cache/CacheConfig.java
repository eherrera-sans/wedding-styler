package com.sanservices.websitesapi.config.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Override
    public KeyGenerator keyGenerator() {
        return new CaseInsensitiveKeyGenerator();
    }
}
