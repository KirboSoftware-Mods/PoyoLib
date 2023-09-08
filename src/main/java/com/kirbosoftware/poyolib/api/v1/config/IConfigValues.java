package com.kirbosoftware.poyolib.api.v1.config;

public interface IConfigValues {
    void set(String key, String value);

    void set(String key, int value);

    void set(String key, boolean value);
    void set(String key, float value);
    void set(String key, double value);
}
