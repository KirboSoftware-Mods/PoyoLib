package com.kirbosoftware.poyolib.api.v1.item.food;

import com.kirbosoftware.poyolib.api.v1.item.food.impl.FoodEssentials;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class FoodType implements FoodEssentials {
    @Override
    public abstract int setHunger();

    @Override
    public abstract float setFullness();

    @Override
    public List<StatusEffectInstance> statusEffectInstanceList() {
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

    public FoodComponent createComponent() {
        FoodComponent.Builder builder = new FoodComponent.Builder()
                .hunger(setHunger())
                .saturationModifier(setFullness());
        for (StatusEffectInstance se : statusEffectInstanceList()) builder.statusEffect(se, setStatusEffectInTicks());
        if (isMeat()) builder.meat();
        if (isSnack()) builder.snack();
        if (isEdible()) builder.alwaysEdible();
        return builder.build();
    }
}
