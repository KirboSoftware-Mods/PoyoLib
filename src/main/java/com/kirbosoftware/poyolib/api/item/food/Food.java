package com.kirbosoftware.poyolib.api.item.food;

public class Food extends FoodType{
    private int hunger = 0;
    private float fullness = 0.0f;

    public Food setHunger(int hunger) {
        this.hunger = hunger;
        return this;
    }

    public Food setFullness(float fullnessModifier) {
        fullness = fullnessModifier;
        return this;
    }

    @Override
    public int setHunger() {
        return hunger;
    }

    @Override
    public float setFullness() {
        return fullness;
    }
}
