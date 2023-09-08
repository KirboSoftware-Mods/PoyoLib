package com.kirbosoftware.poyolib.api.v1.config;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ConfigValue<Boolean> create(String key, boolean value) {
        return new ConfigValue<>(key, value);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ConfigValue<Integer> create(String key, int value) {
        return new ConfigValue<>(key, value);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ConfigValue<Float> create(String key, float value) {
        return new ConfigValue<>(key, value);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ConfigValue<Double> create(String key, double value) {
        return new ConfigValue<>(key, value);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ConfigValue<List<?>> create(String key, List<?> value) {
        return new ConfigValue<>(key, value);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ConfigValue<String> create(String key, String value) {
        return new ConfigValue<>(key, value);
    }
}
