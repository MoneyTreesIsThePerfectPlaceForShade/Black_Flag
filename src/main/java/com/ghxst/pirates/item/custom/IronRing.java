package com.ghxst.pirates.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class IronRing extends Item {

    public IronRing(Properties pProperties) {
        super(pProperties);
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
        return block == Blocks.CHEST || block == Blocks.ENDER_CHEST;
    }


}
