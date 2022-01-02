package com.feywild.feywild.block.trees;

import io.github.noeppi_noeppi.libx.base.decoration.DecoratedBlock;
import io.github.noeppi_noeppi.libx.base.decoration.DecorationContext;
import io.github.noeppi_noeppi.libx.base.decoration.DecorationType;
import io.github.noeppi_noeppi.libx.mod.ModX;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FeyWoodBlock extends DecoratedBlock {

    public static final DecorationContext DECORATION = new DecorationContext("fey_wood", DecorationType.BASE, DecorationType.WALL, DecorationType.SLAB, DecorationType.STAIR);
    
    private final FeyStrippedWoodBlock feyStrippedWood;

    public FeyWoodBlock(ModX mod, FeyStrippedWoodBlock feyStrippedWood, Properties properties, Item.Properties itemProperties) {
        super(mod, DECORATION, properties, itemProperties);
        this.feyStrippedWood = feyStrippedWood;
    }

    public SlabBlock getSlabBlock() {
        return get(DecorationType.SLAB);
    }

    public StairBlock getStairBlock() {
        return get(DecorationType.STAIR);
    }

    public WallBlock getWallBlock() {
        return get(DecorationType.WALL);
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction) {
        return toolAction == ToolActions.AXE_STRIP ? feyStrippedWood.defaultBlockState() : null;
    }
}
