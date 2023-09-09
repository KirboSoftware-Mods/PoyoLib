package com.kirbosoftware.poyolib;

import com.kirbosoftware.poyolib.api.v1.config.ConfigHelper;
import com.kirbosoftware.poyolib.api.v1.config.ConfigValue;

import java.util.List;

public class ExampleConfig {
    private static final ConfigHelper helper = new ConfigHelper(PoyoLib.holder);
    public static ConfigValue<Integer> TEST_INT = helper.getOrCreate("test_int", 11);
    public static ConfigValue<Boolean> TEST_BOOL = helper.getOrCreate("test_bool", false);
}
