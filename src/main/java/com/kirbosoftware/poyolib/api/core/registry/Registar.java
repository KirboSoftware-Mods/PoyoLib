package com.kirbosoftware.poyolib.api.core.registry;

import com.kirbosoftware.poyolib.api.util.LangUtil;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Registar} class provides a simple and easy-to-use mechanism for registering objects
 * with a specified registry, associated with a mod ID. It supports registration of objects with
 * unique paths, allowing for easy retrieval and initialization. Additionally, it provides
 * translation key management for registered objects.
 *
 * @param <T> The type of objects to be registered.
 */
@SuppressWarnings("unused")
public class Registar<T> {

    /** The mod ID associated with the registered objects. */
    private final String MOD_ID;

    /** The registry to use for object registration. */
    private final Registry<T> registry;

    /** The map storing registered objects with their unique paths. */
    private final Map<String, T> entries = new HashMap<>();

    /** The map storing translation keys associated with registered objects. */
    private final Map<String, String> translations = new HashMap<>();

    /**
     * Creates a new instance of {@code Registar} for a specific registry and mod ID.
     *
     * @param registry The registry to use for registration, e.g., {@code Registries.BLOCK}.
     * @param modId The mod ID associated with the objects to be registered.
     */
    Registar(Registry<T> registry, String modId) {
        this.registry = registry;
        this.MOD_ID = modId;
    }

    /**
     * Creates and returns a new instance of {@code Registar} configured with the specified registry and mod ID.
     *
     * @param <T> The type of objects to be registered.
     * @param registry The registry to use for registration, e.g., {@code Registries.BLOCK}.
     * @param modId The mod ID associated with the objects to be registered.
     * @return A new instance of {@code Registar} configured with the specified registry and mod ID.
     */
    public static <T> Registar<T> add(Registry<T> registry, String modId) {
        return new Registar<>(registry, modId);
    }

    /**
     * Registers an object with the specified path.
     *
     * @param path The name/path of the object to register.
     * @param entry The object to be registered.
     * @return A {@code RegEntry} containing information about the registered object, including its identifier.
     * @throws IllegalArgumentException If a duplicate registration with the same path is attempted.
     */
    public RegEntry<T> register(String path, T entry) {
        RegEntry<T> regEntry = RegEntry.create(new Identifier(this.MOD_ID, path), entry);

        // Check for duplicate registration and throw an exception if found
        if (entries.putIfAbsent(path, regEntry.get()) != null) {
            throw new IllegalArgumentException("Duplicate registration " + path);
        }

        if (translations.putIfAbsent(regEntry.getTranslationKey(), LangUtil.capitalizeString(regEntry.getTranslationKey())) != null) {
            throw new IllegalArgumentException("Duplicate translation entries" + regEntry.getTranslationKey());
        }

        // Return the RegEntry containing information about the registered object
        return regEntry;
    }

    /**
     * Gets the mod ID associated with the registered objects.
     *
     * @return The mod ID.
     */
    public String getModId() {
        return MOD_ID;
    }

    /**
     * Gets the registry used for object registration.
     *
     * @return The registry.
     */
    public Registry<T> getRegistry() {
        return registry;
    }

    /**
     * Gets the map of registered objects with their unique paths.
     *
     * @return The map of registered objects.
     */
    public Map<String, T> getEntries() {
        return entries;
    }

    /**
     * Gets the map of translation keys associated with registered objects.
     *
     * @return The map of translation keys.
     */
    public Map<String, String> getTranslations() {
        return translations;
    }
}