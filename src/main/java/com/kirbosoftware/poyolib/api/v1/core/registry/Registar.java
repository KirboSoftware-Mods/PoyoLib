package com.kirbosoftware.poyolib.api.v1.core.registry;

import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Registar<T> {
    private String MOD_ID;
    private Registry<T> registry;
    private final Map<String, T> entries = new HashMap<>();

    /**
     * A simple and easy to register anything
     *
     * @param registry the registry you want to use. e.g. Registries.BLOCK
     * @param modId    the modId
     */
    public Registar(Registry<T> registry, String modId) {
        this.registry = registry;
        this.MOD_ID = modId;
    }

    private Registry<T> getRegistry() {
        return registry;
    }

    /**
     * Registers the object you want to register.
     *
     * @param path  the name/path of said object.
     * @param entry the object.
     * @param <R>   anything that extends the object.
     * @return returns the object.
     */
    public <R extends T> R register(String path, R entry) {
        if (entries.putIfAbsent(path, entry) != null) {
            throw new IllegalArgumentException("Duplicate registration " + path);
        }

        return Registry.register(getRegistry(), new Identifier(getModId(), path), entry);
    }

    public <R extends T> R register(String path, Supplier<R> supplier) {
        R entry = supplier.get();

        if (entries.putIfAbsent(path, entry) != null) {
            throw new IllegalArgumentException("Duplicate registration " + path);
        }

        return Registry.register(getRegistry(), new Identifier(getModId(), path), entry);
    }

    public Registar<T> set(Registry<T> registry, String modId) {
        return new Registar<>(registry, modId);
    }

    private String getModId() {
        return MOD_ID;
    }

    public Map<String, T> getEntries() {
        return entries;
    }
}
