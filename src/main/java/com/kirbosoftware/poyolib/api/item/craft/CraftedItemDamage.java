package com.kirbosoftware.poyolib.api.item.craft;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * The {@code CraftedItemDamage} class represents a crafted item with durability that can be depleted over time.
 * It extends the {@code Item} class and implements specific functionality for items with damage.
 */
public class CraftedItemDamage extends Item {

    /**
     * Constructs a new {@code CraftedItemDamage} with the specified maximum damage and properties.
     *
     * @param maxDamage   The maximum damage the crafted item can endure.
     * @param properties  The properties of the crafted item, including default durability.
     */
    public CraftedItemDamage(int maxDamage, Properties properties) {
        super(properties.defaultDurability(maxDamage));
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
        if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
            ItemStack copy = stack.copy();
            copy.setDamageValue(stack.getDamageValue() + 1);
            return copy;
        } else {
            return ItemStack.EMPTY;
        }
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