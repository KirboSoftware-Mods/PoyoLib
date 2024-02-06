package com.kirbosoftware.poyolib.api.core.registry;

import net.minecraft.resources.ResourceLocation;

/**
 * A simple container class representing an entry registered in a {@code Registar}.
 *
 * @param <T> The type of the registered object.
 */
@SuppressWarnings("unused")
public class RegEntry<T> {
    private final T entry;
    private final ResourceLocation identifier;

    /**
     * Private constructor to create a {@code RegEntry} with the specified identifier and object.
     *
     * @param identifier The identifier associated with the registered object.
     * @param entry      The registered object.
     */
    private RegEntry(ResourceLocation identifier, T entry) {
        this.identifier = identifier;
        this.entry = entry;
    }

    /**
     * Creates a new instance of {@code RegEntry} with the specified identifier and object.
     *
     * @param <T>        The type of the registered object.
     * @param identifier The identifier associated with the registered object.
     * @param entry      The registered object.
     * @return A new instance of {@code RegEntry} containing the specified identifier and object.
     */
    public static <T> RegEntry<T> create(ResourceLocation identifier, T entry) {
        return new RegEntry<>(identifier, entry);
    }

    /**
     * Retrieves the registered object.
     *
     * @return The registered object.
     */
    public T get() {
        return entry;
    }

    /**
     * Retrieves the identifier associated with the registered object.
     *
     * @return The identifier associated with the registered object.
     */
    public ResourceLocation getId() {
        return identifier;
    }

    /**
     * Retrieves the translationKey associated with the registered object.
     *
     * @return The translationKey associated with the registered object.
     */
    public String getTranslationKey() {
        return identifier.toLanguageKey();
    }
}