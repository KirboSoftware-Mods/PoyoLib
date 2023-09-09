package com.kirbosoftware.poyolib.api.v1.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.random.Random;

@SuppressWarnings("unused")
public class DamageableToolCraftingItem extends Item {
    public DamageableToolCraftingItem(ToolMaterial material,  Settings settings) {
        super(settings.maxDamage(material.getDurability()));
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack copy = stack.copy();
        if (copy.damage(1, Random.create(), null))
            return ItemStack.EMPTY;
        else
            return copy;
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }
}
