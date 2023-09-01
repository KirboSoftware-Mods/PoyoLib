package com.joostmsoftware.poyolib.api.v1.item.food;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Food {
    private final int hunger;
    private final float saturationModifier;
    private final List<StatusEffectInstance> effect = new ArrayList<>();
    private float effectChance;
    private boolean meat = false;
    private boolean snack = false;
    private boolean alwaysEdible = false;

    public Food(int hunger, float saturationModifier) {
        this.hunger = hunger;
        this.saturationModifier = saturationModifier;
    }

    public Food addEffect(StatusEffect effect, int effectDurationInTicks, float chance) {
        this.effect.add(new StatusEffectInstance(effect, effectDurationInTicks));
        this.effectChance = chance;
        return this;
    }

    public Food isMeat() {
        this.meat = true;
        return this;
    }

    public Food isSnack() {
        this.snack = true;
        return this;
    }

    public Food alwaysEdible() {
        this.alwaysEdible = true;
        return this;
    }

    public FoodComponent createComponent() {
        FoodComponent.Builder builder = new FoodComponent.Builder()
                .hunger(this.hunger)
                .saturationModifier(this.saturationModifier);

        for (StatusEffectInstance se: this.effect) builder.statusEffect(se, this.effectChance);

        if (meat) builder.meat();

        if (snack) builder.snack();

        if (alwaysEdible) builder.alwaysEdible();

        return builder.build();
    }

    public Item asItem() {
        return new Item(new Item.Settings().food(createComponent()));
    }
}
