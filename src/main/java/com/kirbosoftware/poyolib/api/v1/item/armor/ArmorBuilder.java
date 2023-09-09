package com.kirbosoftware.poyolib.api.v1.item.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

@SuppressWarnings("unused")
public class ArmorBuilder {
    public static class Helmet extends ArmorItem {
        /**
         * Creates a helmet with the chosen materials.
         * @param material The armor material.
         * @param settings Item settings.
         */
        public Helmet(ArmorMaterial material, Settings settings) {
            super(material, Type.HELMET, settings.maxCount(1));
        }
    }

    public static class Chestplate extends ArmorItem {
        /**
         * Creates a chestplate with the chosen materials.
         * @param material The armor material.
         * @param settings Item settings.
         */
        public Chestplate(ArmorMaterial material, Settings settings) {
            super(material, Type.CHESTPLATE, settings.maxCount(1));
        }
    }

    public static class Leggings extends ArmorItem {
        /**
         * Creates a pair of leggings with the chosen materials.
         * @param material The armor material.
         * @param settings Item settings.
         */
        public Leggings(ArmorMaterial material, Settings settings) {
            super(material, Type.LEGGINGS, settings.maxCount(1));
        }
    }

    public static class Boots extends ArmorItem {
        /**
         * Creates a pair of boots with the chosen materials.
         * @param material The armor material.
         * @param settings Item settings.
         */
        public Boots(ArmorMaterial material, Settings settings) {
            super(material, Type.BOOTS, settings.maxCount(1));
        }
    }
}