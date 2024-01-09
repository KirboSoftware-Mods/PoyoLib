package com.kirbosoftware.poyolib.api.item.craft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

public class CraftedItemDamage extends Item {
    public CraftedItemDamage(int maxDamage, Settings settings) {
        super(settings.maxDamage(maxDamage));
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
