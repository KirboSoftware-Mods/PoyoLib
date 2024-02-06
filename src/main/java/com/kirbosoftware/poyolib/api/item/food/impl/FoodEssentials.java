package com.kirbosoftware.poyolib.api.item.food.impl;

import net.minecraft.world.effect.MobEffectInstance;
import java.util.List;

public interface FoodEssentials {
    int setHunger();
    float setFullness();
    boolean isSnack();
    boolean isMeat();
    boolean isEdible();
    List<MobEffectInstance> statusEffectInstanceList();
    float setStatusEffectInTicks();
}
