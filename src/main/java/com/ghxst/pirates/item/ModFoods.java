package com.ghxst.pirates.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties AKATSU_POTION = (new FoodProperties.Builder()).nutrition(0).saturationMod(0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 1.0F).alwaysEat().build();

    public static final FoodProperties KENROCK_POTION = (new FoodProperties.Builder()).nutrition(0).saturationMod(0F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1), 1.0F).alwaysEat().build();

    public static final FoodProperties MIDORI_POTION = (new FoodProperties.Builder()).nutrition(0).saturationMod(0F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1), 1.0F).alwaysEat().build();

    public static final FoodProperties PAPURU_POTION = (new FoodProperties.Builder()).nutrition(0).saturationMod(0F).effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 1), 1.0F).alwaysEat().build();

}
