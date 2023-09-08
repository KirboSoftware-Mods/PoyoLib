package com.kirbosoftware.poyolib.api.v1.config;

import java.util.Properties;

public interface IPoyoConfig extends IConfigValues {
    String getFileName();
    Properties getProperties();
    void init();

    default void set(String key, String value) {
        getProperties().setProperty(key, value);
    }

    default void set(String key, int value) {
        getProperties().setProperty(key, String.valueOf(value));
    }

    default void set(String key, boolean value) {
        getProperties().setProperty(key, String.valueOf(value));
    }

    default void set(String key, float value) {
        getProperties().setProperty(key, String.valueOf(value));
    }

    default void set(String key, double value) {
        getProperties().setProperty(key, String.valueOf(value));
    };
}