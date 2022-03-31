package com.ghxst.pirates.item;

import com.ghxst.pirates.Pirates;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
// класс для добавления новых предметов
public class ModItems {
    // константа, нужная для регистрации предметов в игре
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Pirates.MOD_ID);

    //так добавляется новый предмет
    //добавляем золотые монеты, они будут находиться в misc в творческом меню
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // метод, который регистрирует предметы в игре
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }





}
