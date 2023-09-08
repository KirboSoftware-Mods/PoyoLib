package com.kirbosoftware.poyolib;

import com.kirbosoftware.poyolib.api.v1.config.IPoyoConfig;
import com.kirbosoftware.poyolib.api.v1.config.PoyoConfigManager;
import net.fabricmc.api.ModInitializer;;

public class PoyoLib implements ModInitializer {
    @Override
    public void onInitialize() {
        IPoyoConfig config = new Config("poyolib");
        PoyoConfigManager.load(config);
        config.init();
        PoyoConfigManager.store(config);
    }
}
