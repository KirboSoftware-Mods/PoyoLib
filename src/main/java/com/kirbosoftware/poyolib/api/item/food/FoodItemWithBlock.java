package com.kirbosoftware.poyolib.api.item.food;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class FoodItemWithBlock extends BlockItem {
    public FoodItemWithBlock(Block block, @NotNull Properties properties, @NotNull FoodType foodType) {
        super(block, properties.food(foodType.createComponent()));
    }
}
