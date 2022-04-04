package com.ghxst.pirates.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier HAKU = new ForgeTier(2, 1400, 1.5f, 2f, 20, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.HAKU_GEM.get()));
}
