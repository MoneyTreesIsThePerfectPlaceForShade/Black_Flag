package com.ghxst.pirates.item.sound;

import com.ghxst.pirates.Pirates;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Pirates.MOD_ID);
// добавляем звук
    public static final RegistryObject<SoundEvent> SPRING_WALK = registerSoundEvent("spring_walk");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Pirates.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
