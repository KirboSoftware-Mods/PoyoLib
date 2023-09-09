package com.kirbosoftware.poyolib;

import com.kirbosoftware.poyolib.api.v1.config.ConfigHolder;
import com.kirbosoftware.poyolib.api.v1.config.ConfigManager;
import com.kirbosoftware.poyolib.util.Util;
import net.fabricmc.api.ModInitializer;

public class PoyoLib implements ModInitializer {
    public static ConfigHolder holder = new ConfigHolder("poyolib");
    @Override
    public void onInitialize() {
        holder.add(new ExampleConfig());
        ConfigManager.load(holder);
        ConfigManager.store(holder);

        Util.LOGGER.info("the value of this boolean is: ${}", ExampleConfig.TEST_BOOL.get());
        Util.LOGGER.info("the value of this integer is: ${}", ExampleConfig.TEST_INT.get());
    }
}
