package com.kirbosoftware.poyolib.api.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

@SuppressWarnings("unused")
public class ArmorBuilder {
    public static class Helmet extends ArmorItem {
        /**
         * Creates a helmet with the chosen materials.
         * @param holder The armor material.
         * @param properties Item properties.
         */
        public Helmet(Holder<ArmorMaterial> holder, Properties properties) {
            super(holder, Type.HELMET, properties.stacksTo(1));
        }
    }

    public static class Chestplate extends ArmorItem {
        /**
         * Creates a chestplate with the chosen materials.
         * @param holder The armor material.
         * @param properties Item properties.
         */
        public Chestplate(Holder<ArmorMaterial> holder, Properties properties) {
            super(holder, Type.CHESTPLATE, properties.stacksTo(1));
        }
    }

    public static class Leggings extends ArmorItem {
        /**
         * Creates a pair of leggings with the chosen materials.
         * @param holder The armor material.
         * @param properties Item properties.
         */
        public Leggings(Holder<ArmorMaterial> holder, Properties properties) {
            super(holder, Type.LEGGINGS, properties.stacksTo(1));
        }
    }

    public static class Boots extends ArmorItem {
        /**
         * Creates a pair of boots with the chosen materials.
         * @param holder The armor material.
         * @param properties Item properties.
         */
        public Boots(Holder<ArmorMaterial> holder, Properties properties) {
            super(holder, Type.BOOTS, properties.stacksTo(1));
        }
    }
}