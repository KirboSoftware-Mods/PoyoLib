package com.kirbosoftware.poyolib.api.item.food;

import com.kirbosoftware.poyolib.api.item.food.impl.FoodEssentials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

import java.util.ArrayList;
import java.util.List;

public abstract class FoodType implements FoodEssentials {
    @Override
    public abstract int setHunger();

    @Override
    public abstract float setFullness();

    @Override
    public List<MobEffectInstance> statusEffectInstanceList() {
        return new ArrayList<>();
    }

    @Override
    public float setStatusEffectInTicks() {
        return 0;
    }

    @Override
    public boolean isMeat() {
        return false;
    }

    @Override
    public boolean isSnack() {
        return false;
    }

    @Override
    public boolean isEdible() {
        return false;
    }

    public FoodProperties createComponent() {
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(setHunger())
                .saturationMod(setFullness());
        for (MobEffectInstance se : statusEffectInstanceList()) builder.effect(se, setStatusEffectInTicks());
        if (isMeat()) builder.meat();
        if (isSnack()) builder.fast();
        if (isEdible()) builder.alwaysEat();
        return builder.build();
    }
}
