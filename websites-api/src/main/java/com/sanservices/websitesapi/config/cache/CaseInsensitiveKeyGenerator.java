package com.sanservices.websitesapi.config.cache;

import lombok.val;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;

import java.lang.reflect.Method;

public final class CaseInsensitiveKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        if (params.length == 0) {
            return SimpleKey.EMPTY;
        }
        if (params.length == 1) {
            val param = params[0];
            if (param != null && !param.getClass().isArray()) {
                if (param instanceof String) {
                    return ((String) param).toUpperCase();
                }

                return param;
            }
        }

        return new CaseInsensitiveKey(params);
    }
}
