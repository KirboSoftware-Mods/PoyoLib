package com.kirbosoftware.poyolib.api.v1.config;

@SuppressWarnings("unused")
public class ConfigValue<T> {
    private final String key;
    private T value;

    public ConfigValue(String key, T value) {
        this.key = key;
        this.value = value;
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
