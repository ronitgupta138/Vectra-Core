package com.vectracore.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Key-value metadata attached to vector items for attribute filtering.
 */
public class VectorMetadata {
    private final Map<String, String> attributes;

    public VectorMetadata(Map<String, String> attributes) {
        this.attributes = (attributes != null) ? new HashMap<>(attributes) : new HashMap<>();
    }

    public static VectorMetadata empty() {
        return new VectorMetadata(Collections.emptyMap());
    }

    public String get(String key) {
        return attributes.get(key);
    }

    public boolean matches(String key, String expectedValue) {
        return Objects.equals(attributes.get(key), expectedValue);
    }

    public Map<String, String> asMap() {
        return Collections.unmodifiableMap(attributes);
    }
}
