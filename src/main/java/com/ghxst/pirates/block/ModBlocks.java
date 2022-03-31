package com.ghxst.pirates.block;

import com.ghxst.pirates.Pirates;
import com.ghxst.pirates.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    //также как и в ModItems добавляем переменную для регистрации, в данном случае, блоков
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Pirates.MOD_ID);

    // добавляем блок бамбука
    public static final RegistryObject<Block> BAMBOO_BLOCK = registerBlock("bamboo_block", () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO).strength(9f).requiresCorrectToolForDrops()),CreativeModeTab.TAB_BUILDING_BLOCKS);

    // регистрирует блок
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    // регистрирует предмет, который связан с блоком
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    // метод, который регистрирует блоки в игре
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
