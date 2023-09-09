package com.kirbosoftware.poyolib.api.v1.config;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("unused")
public class ConfigHelper {
    private static ConfigHolder holder;

    public ConfigHelper(ConfigHolder holder) {
        ConfigHelper.holder = holder;
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull ConfigValue<Boolean> getOrCreate(String key, boolean value) {
        if (holder.hasValue(key)) {
            // Use the value from the config file
            return new ConfigValue<>(key, (Boolean) holder.getValue(key).get());
        } else {
            // Use the default value
            return new ConfigValue<>(key, value);
        }
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull ConfigValue<Integer> getOrCreate(String key, int value) {
        if (holder.hasValue(key)) {
            // Use the value from the config file
            return new ConfigValue<>(key, (Integer) holder.getValue(key).get());
        } else {
            // Use the default value
            return new ConfigValue<>(key, value);
        }
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull ConfigValue<Float> getOrCreate(String key, float value) {
        if (holder.hasValue(key)) {
            // Use the value from the config file
            return new ConfigValue<>(key, (Float) holder.getValue(key).get());
        } else {
            // Use the default value
            return new ConfigValue<>(key, value);
        }
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull ConfigValue<Double> getOrCreate(String key, double value) {
        if (holder.hasValue(key)) {
            // Use the value from the config file
            return new ConfigValue<>(key, (Double) holder.getValue(key).get());
        } else {
            // Use the default value
            return new ConfigValue<>(key, value);
        }
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull ConfigValue<List<?>> getOrCreate(String key, List<?> value) {
        if (holder.hasValue(key)) {
            // Use the value from the config file
            return new ConfigValue<>(key, (List<?>) holder.getValue(key).get());
        } else {
            // Use the default value
            return new ConfigValue<>(key, value);
        }
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull ConfigValue<String> getOrCreate(String key, String value) {
        if (holder.hasValue(key)) {
            // Use the value from the config file
            return new ConfigValue<>(key, (String) holder.getValue(key).get());
        } else {
            // Use the default value
            return new ConfigValue<>(key, value);
        }
    }
}
