package com.kirbosoftware.poyolib.api.item.food;

import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class FoodItem extends Item {
    public FoodItem(@NotNull Properties properties, @NotNull FoodType food) {
        super(properties.food(food.createComponent()));
    }
}
