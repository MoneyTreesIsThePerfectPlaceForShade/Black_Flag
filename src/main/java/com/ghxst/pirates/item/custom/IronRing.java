package com.ghxst.pirates.item.custom;

import com.ghxst.pirates.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Scanner;

public class IronRing extends Item {

    public IronRing(Properties pProperties) {
        super(pProperties);
    }

    //  добавляем тултип

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()){//если нажат шифт
            pTooltipComponents.add(new TranslatableComponent("tooltip.pirates.iron_ring.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.pirates.iron_ring.tooltip"));
        }
    }


    // это кольцо помогает находить сундуки пиратов

    @Override
    public InteractionResult useOn(UseOnContext pContext){

        if (pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() +64; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if (isValuebleBlock(blockBelow)){
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock){
                player.sendMessage(new TranslatableComponent("item.pirates.iron_ring.no_valuables"), player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return super.useOn(pContext);
    }
    // пишем игроку коорды сундука
    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow){
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString()+" at "+"("
        +blockPos.getX()+", "+blockPos.getY()+", "+blockPos.getZ()+")"), player.getUUID()) ;
    }
    // возрвращаем сундук и эндер сундук
    private boolean isValuebleBlock(Block block){
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(ModTags.BLocks.IRON_RING_VALUABLES);
    }


}
