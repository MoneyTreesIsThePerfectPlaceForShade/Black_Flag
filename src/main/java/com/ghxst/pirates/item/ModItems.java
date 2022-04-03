package com.ghxst.pirates.item;

import com.ghxst.pirates.Pirates;
import com.ghxst.pirates.item.custom.IronRing;
import com.ghxst.pirates.item.custom.MeteorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.rmi.registry.Registry;
// класс для добавления новых предметов
public class ModItems {
    // константа, нужная для регистрации предметов в игре
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Pirates.MOD_ID);

    //так добавляется новый предмет
    //добавляем золотые монеты, они будут находиться в misc в творческом меню
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));
    // медная монета
    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));
    // железная монета
    public static final RegistryObject<Item> IRON_COIN = ITEMS.register("iron_coin", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));
    // металическая монета
    public static final RegistryObject<Item> METAL_COIN = ITEMS.register("metal_coin", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));
    // добавил хаку гем
    public static final RegistryObject<Item> HAKU_GEM = ITEMS.register("haku_gem", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));
    // добавил комакамо гем
    public static final RegistryObject<Item> KOMAKAMO_GEM = ITEMS.register("komakamo_gem", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));
    // добавил маако гем
    public static final RegistryObject<Item> MAAKO_GEM = ITEMS.register("maako_gem", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));
    // добавил йома гем
    public static final RegistryObject<Item> YOMA_GEM = ITEMS.register("yoma_gem", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));

    // добавил железное кольцо // когда добавляешь сложный предмет (создавая свой класс), нужно менять Item на наш класс // также тут пример того, как добавить прочность предмету
    public static final RegistryObject<Item> IRON_RING = ITEMS.register("iron_ring", () -> new IronRing(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB).durability(64)));

    // добавляем еду разные виды зелий
    public static final RegistryObject<Item> AKATSU_POTION = ITEMS.register("akatsu_potion", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB).food(ModFoods.AKATSU_POTION)));
    public static final RegistryObject<Item> KENROCK_POTION = ITEMS.register("kenrock_potion", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB).food(ModFoods.KENROCK_POTION)));
    public static final RegistryObject<Item> MIDORI_POTION = ITEMS.register("midori_potion", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB).food(ModFoods.MIDORI_POTION)));
    public static final RegistryObject<Item> PAPURU_POTION = ITEMS.register("papuru_potion", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB).food(ModFoods.PAPURU_POTION)));

    // добавляем метеор в качестве горючего
    public static final RegistryObject<Item> METEOR = ITEMS.register("meteor", () -> new MeteorItem(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB).food(ModFoods.PAPURU_POTION)));

    // добавил черный флаг для иконки
    public static final RegistryObject<Item> BLACK_FLAG_ITEM = ITEMS.register("black_flag_item", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BLACK_FLAG_TAB)));

    // метод, который регистрирует предметы в игре
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }





}
