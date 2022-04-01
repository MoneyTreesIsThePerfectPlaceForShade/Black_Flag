package com.ghxst.pirates.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab BLACK_FLAG_TAB = new CreativeModeTab("black_flag_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BLACK_FLAG_ITEM.get());
        }
    };
}
