package com.kirbosoftware.poyolib.api.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Config {
    private static final Map<String, ConfigValue<?>> configValues = new HashMap<>();

    public static ConfigValue<Boolean> addBoolean(String key, boolean value) {
        ConfigValue<Boolean> configValue = (ConfigValue<Boolean>) configValues.get(key);
        if (configValue != null) {
            // Use the value from the config file
            return configValue;
        } else {
            ConfigValue<Boolean> newValue = ConfigValue.create(key, value);
            configValues.put(key, newValue);
            // Use the default value
            return newValue;
        }
    }

    public static ConfigValue<Integer> addInteger(String key, int value) {
        ConfigValue<Integer> configValue = (ConfigValue<Integer>) configValues.get(key);
        if (configValue != null) {
            // Use the value from the config file
            return configValue;
        } else {
            ConfigValue<Integer> newValue = ConfigValue.create(key, value);
            configValues.put(key, newValue);
            // Use the default value
            return newValue;
        }
    }

    public static ConfigValue<Float> addFloat(String key, float value) {
        ConfigValue<Float> configValue = (ConfigValue<Float>) configValues.get(key);
        if (configValue != null) {
            // Use the value from the config file
            return configValue;
        } else {
            ConfigValue<Float> newValue = ConfigValue.create(key, value);
            configValues.put(key, newValue);
            // Use the default value
            return newValue;
        }
    }

    public static ConfigValue<Double> addDouble(String key, double value) {
        ConfigValue<Double> configValue = (ConfigValue<Double>) configValues.get(key);
        if (configValue != null) {
            // Use the value from the config file
            return configValue;
        } else {
            ConfigValue<Double> newValue = ConfigValue.create(key, value);
            configValues.put(key, newValue);
            // Use the default value
            return newValue;
        }
    }

    public static ConfigValue<Long> addLong(String key, long value) {
        ConfigValue<Long> configValue = (ConfigValue<Long>) configValues.get(key);
        if (configValue != null) {
            // Use the value from the config file
            return configValue;
        } else {
            ConfigValue<Long> newValue = ConfigValue.create(key, value);
            configValues.put(key, newValue);
            // Use the default value
            return newValue;
        }
    }

    public static ConfigValue<String> addString(String key, String value) {
        ConfigValue<String> configValue = (ConfigValue<String>) configValues.get(key);
        if (configValue != null) {
            // Use the value from the config file
            return configValue;
        } else {
            ConfigValue<String> newValue = ConfigValue.create(key, value);
            configValues.put(key, newValue);
            // Use the default value
            return newValue;
        }
    }



    protected List<ConfigValue<?>> getConfigValues() {
        return new ArrayList<>(configValues.values());
    }
}
