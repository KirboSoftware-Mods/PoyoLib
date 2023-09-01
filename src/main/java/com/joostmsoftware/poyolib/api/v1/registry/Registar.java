package com.joostmsoftware.poyolib.api.v1.registry;

import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Registar<T> {
    private final String MOD_ID;
    private final Registry<T> registry;
    private final Map<String, T> entries = new LinkedHashMap<>();

    public Registar(Registry<T> registry, String modId) {
        this.registry = registry;
        this.MOD_ID = modId;
    }

    private Registry<T> getRegistry() {
        return registry;
    }

    public <R extends T> R register(String path, R entry) {
        if (entries.putIfAbsent(path, entry) != null) {
            throw new IllegalArgumentException("Duplicate registration " + path);
        }

        return Registry.register(getRegistry(), new Identifier(getModId(), path), entry);
    }


    private String getModId() {
        return MOD_ID;
    }

    public Map<String, T> getEntries() {
        return entries;
    }
}
