package com.kirbosoftware.poyolib.api.v1.core.registry;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class TagRegistar<T> {
    private final RegistryKey<? extends Registry<T>> key;
    private final String modId;
    private final List<String> entries = new ArrayList<>();

    public TagRegistar(RegistryKey<? extends Registry<T>> key, String modId) {
        this.key = key;
        this.modId = modId;
    }

    public TagKey<T> register(String path) {
        if (entries.contains(path)) {
            throw new IllegalArgumentException("Duplicate registration " + path);
        }

        return TagKey.of(getKey(), new Identifier(getModId(), path));
    }

    public RegistryKey<? extends Registry<T>> getKey() {
        return key;
    }

    public String getModId() {
        return modId;
    }

    public List<String> getEntries() {
        return entries;
    }
}
