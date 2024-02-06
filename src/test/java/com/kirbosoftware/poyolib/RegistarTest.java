package com.kirbosoftware.poyolib;

import com.kirbosoftware.poyolib.api.core.registry.RegEntry;
import com.kirbosoftware.poyolib.api.core.registry.Registar;
import net.minecraft.SharedConstants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RegistarTest {
    private static final String MOD_ID = "example_mod";
    private Registar<Item> itemRegistar;

    @BeforeEach
    void setup() {
        SharedConstants.tryDetectVersion();
        Bootstrap.bootStrap();

        itemRegistar = Registar.add(BuiltInRegistries.ITEM, MOD_ID);
    }

    @Test
    void registerAndGetEntries() {
        RegEntry<Item> regEntry = itemRegistar.register("test", Items.DIAMOND);

        assertNotNull(regEntry);
        assertEquals("example_mod:test", regEntry.getId().toString());
        assertEquals(Items.DIAMOND, regEntry.get());
    }

    @Test
    void registerDuplicateEntry() {
        // Register an object
        RegEntry<Item> regEntry = itemRegistar.register("example_entry", Items.APPLE);

        // Attempt to register a duplicate entry with the same path, should throw an exception
        assertThrows(IllegalArgumentException.class, () ->
                itemRegistar.register("example_entry", Items.GOLDEN_APPLE));
    }

    @Test
    void getModId() {
        // Check if the getModId method returns the correct mod ID
        assertEquals(MOD_ID, itemRegistar.getModId());
    }

    @Test
    void getRegistry() {
        // Check if the getRegistry method returns the correct registry
        assertEquals(BuiltInRegistries.ITEM, itemRegistar.getRegistry());
    }

    @Test
    void getTranslations() {
        // Register an object
        RegEntry<Item> regEntry = itemRegistar.register("example_entry", Items.GOLD_BLOCK);

        // Check if the translations map contains the translation key
        Map<String, String> translations = itemRegistar.getTranslations();
        assertTrue(translations.containsKey(regEntry.getTranslationKey()));
        assertEquals("Example_Mod.Example_Entry", translations.get(regEntry.getTranslationKey()));
    }
}
