package com.kirbosoftware.poyolib;

import com.kirbosoftware.poyolib.api.v1.config.IPoyoConfig;

import java.util.Properties;

public class Config implements IPoyoConfig {
    private final Properties properties = new Properties();
    private final String name;
    public Config(String fileName) {
        name = fileName;
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public void init() {
        set("group.key", "groupName");
        set("group.whatIsTheNumber", 10);
        set("group.isGood", false);
        set("anotherGroup.test", "testing");
    }

    @Override
    public String getFileName() {
        return name;
    }
}
