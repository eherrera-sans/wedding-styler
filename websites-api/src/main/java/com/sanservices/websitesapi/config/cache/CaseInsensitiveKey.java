package com.sanservices.websitesapi.config.cache;

import lombok.val;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;

public final class CaseInsensitiveKey implements Serializable {
    private static final long serialVersionUID = 9008090125781866589L;

    private final Object[] params;
    private final int hashCode;
    private final String asString;

    public CaseInsensitiveKey(Object... params) {
        this.params = new Object[params.length];
        System.arraycopy(params, 0, this.params, 0, params.length);
        for (int i = 0; i < this.params.length; i++) {
            val obj = this.params[i];
            if (obj instanceof String) {
                this.params[i] = ((String) obj).toUpperCase();
            }
        }

        this.hashCode = Arrays.deepHashCode(this.params);
        this.asString = "CaseInsensitiveKey{" + StringUtils.arrayToCommaDelimitedString(this.params) + '}';
    }

    @Override
    public String toString() {
        return asString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        val that = (CaseInsensitiveKey) o;
        return Arrays.deepEquals(params, that.params);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
}
