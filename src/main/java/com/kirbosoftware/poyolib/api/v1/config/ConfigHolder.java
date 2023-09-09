package com.kirbosoftware.poyolib.api.v1.config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigHolder {
    private final String filePath;
    private Object object;

    public ConfigHolder(String fileName) {
        this.filePath = fileName;
    }


    public String getFileName() {
        return filePath;
    }

    private final Map<String, ConfigValue<?>> configValues = new HashMap<>();

    private  <T> void addConfigValue(ConfigValue<T> configValue) {
        configValues.put(configValue.getKey(), configValue);
    }

    public <T> ConfigValue<T> getValue(String key) {
        return (ConfigValue<T>) configValues.get(key);
    }

    public List<ConfigValue<?>> getValues() {
        return new ArrayList<>(configValues.values());
    }

    public void add(Object object) {
        this.object = object;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == ConfigValue.class) {
                try {
                    field.setAccessible(true);
                    ConfigValue<?> configValue = (ConfigValue<?>) field.get(object);
                    addConfigValue(configValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasValue(String key) {
        return configValues.containsKey(key);
    }
}