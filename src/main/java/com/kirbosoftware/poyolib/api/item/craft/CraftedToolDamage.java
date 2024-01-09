package com.kirbosoftware.poyolib.api.item.craft;

import net.minecraft.item.ToolMaterial;

@SuppressWarnings("unused")
public class CraftedToolDamage extends CraftedItemDamage {
    public CraftedToolDamage(ToolMaterial material, Settings settings) {
        super(material.getDurability(), settings);
    }
}
