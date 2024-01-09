package com.kirbosoftware.poyolib.api.config;

public class ConfigValue<T> {
    private final String key;
    private T value;

    public ConfigValue(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> ConfigValue<T> create(String key, T value) {
        return new ConfigValue<>(key, value);
    }

    /**
     * Returns the key you've set
     * @return The key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the object you've set.
     * @return The object.
     */
    public T get() {
        return value;
    }

    public void setValue(Object value) {
        this.value = (T) value; // Safe cast
    }
}
