package com.kirbosoftware.poyolib.api.v1.item.food;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class FoodItemWithBlock extends BlockItem {
    public FoodItemWithBlock(Block block, @NotNull Settings settings, @NotNull Food food) {
        super(block, settings.food(food.createComponent()));
    }
}
