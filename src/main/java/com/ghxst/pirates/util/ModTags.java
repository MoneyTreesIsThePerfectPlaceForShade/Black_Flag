package com.ghxst.pirates.util;

import com.ghxst.pirates.Pirates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class BLocks{
        public static final TagKey<Block> IRON_RING_VALUABLES = tagKey("iron_ring_valuables");

        private static TagKey<Block> tagKey(String name){
            return BlockTags.create(new ResourceLocation(Pirates.MOD_ID, name));
        }
        private static TagKey<Block> forgetagKey(String name){
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
    public static class Items{
        private static TagKey<Item> tagKey(String name){
            return ItemTags.create(new ResourceLocation(Pirates.MOD_ID, name));
        }
        private static TagKey<Item> forgetagKey(String name){
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
