package com.kirbosoftware.poyolib;

import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SetupMinecraftCallback implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        SharedConstants.createGameVersion();
        Bootstrap.initialize();
    }
}
