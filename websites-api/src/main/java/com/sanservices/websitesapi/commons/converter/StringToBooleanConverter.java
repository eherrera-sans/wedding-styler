package com.sanservices.websitesapi.commons.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public final class StringToBooleanConverter implements Converter<String, Boolean> {
    private static final Set<String> trueValues = new HashSet<>(4);

    private static final Set<String> falseValues = new HashSet<>(4);

    static {
        trueValues.add("true");
        trueValues.add("on");
        trueValues.add("yes");
        trueValues.add("1");
        trueValues.add("y");

        falseValues.add("false");
        falseValues.add("off");
        falseValues.add("no");
        falseValues.add("0");
        falseValues.add("n");
    }

    @Override
    public Boolean convert(String source) {
        String value = source.trim();
        if (value.isEmpty()) {
            return null;
        }
        value = value.toLowerCase();
        if (trueValues.contains(value)) {
            return Boolean.TRUE;
        } else if (falseValues.contains(value)) {
            return Boolean.FALSE;
        } else {
            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
        }
    }
}
