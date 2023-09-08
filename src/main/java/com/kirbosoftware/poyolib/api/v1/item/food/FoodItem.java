package com.kirbosoftware.poyolib.api.v1.item.food;

import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class FoodItem extends Item {
    public FoodItem(@NotNull Settings settings, @NotNull Food food) {
        super(settings.food(food.createComponent()));
    }
}
