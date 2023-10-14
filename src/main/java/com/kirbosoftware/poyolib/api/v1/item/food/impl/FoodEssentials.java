package com.kirbosoftware.poyolib.api.v1.item.food.impl;

import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.List;

public interface FoodEssentials {
    int setHunger();
    float setFullness();
    boolean isSnack();
    boolean isMeat();
    boolean isEdible();
    List<StatusEffectInstance> statusEffectInstanceList();
    float setStatusEffectInTicks();
}
