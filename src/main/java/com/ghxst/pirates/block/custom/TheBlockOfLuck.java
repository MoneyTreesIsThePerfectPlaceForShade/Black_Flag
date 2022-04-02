package com.ghxst.pirates.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TheBlockOfLuck extends Block {

    public TheBlockOfLuck(Properties p_49795_) {
        super(p_49795_);
    }
    // когда игрок встает на блок, он получает + к удаче
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pLevel.isClientSide()){
            if (pEntity instanceof LivingEntity){
                LivingEntity livingEntity = ((LivingEntity) pEntity);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.LUCK, 3600));
            }
        }

    super.stepOn(pLevel, pPos, pState, pEntity);
    }



}
