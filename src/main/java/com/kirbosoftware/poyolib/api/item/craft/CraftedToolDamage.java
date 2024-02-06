package com.kirbosoftware.poyolib.api.item.craft;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;

/**
 * The {@code CraftedToolDamage} class represents a crafted tool with durability that can be depleted over time.
 * It extends the {@code CraftedItemDamage} class, inheriting functionality for items with damage.
 */
public class CraftedToolDamage extends TieredItem {

    /**
     * Constructs a new {@code CraftedToolDamage} with the specified tier and properties.
     *
     * @param tier       The tier of the tool, determining its maximum uses and effectiveness.
     * @param properties The properties of the crafted tool, including default durability.
     */
    public CraftedToolDamage(Tier tier, Properties properties) {
        super(tier, properties);
    }

    /**
     * Checks if the crafted item can be depleted, indicating it has durability that decreases with use.
     *
     * @return {@code true} if the item can be depleted; {@code false} otherwise.
     */
    @Override
    public boolean canBeDepleted() {
        return true;
    }

    /**
     * Retrieves the remaining item after crafting, considering durability reduction.
     *
     * @param stack The original item stack before crafting.
     * @return An {@code ItemStack} representing the remaining item after crafting, or {@code ItemStack.EMPTY} if depleted.
     */
    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack copy = stack.copy();
        if (copy.hurt(1, RandomSource.create(), null))
            return ItemStack.EMPTY;
        else
            return copy;
    }

    /**
     * Checks if the crafted item has a remaining item after crafting.
     *
     * @return {@code true} if there is a remaining item after crafting; {@code false} otherwise.
     */
    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }
}
