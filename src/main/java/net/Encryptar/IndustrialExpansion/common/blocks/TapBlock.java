package net.Encryptar.IndustrialExpansion.common.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import javax.annotation.Nullable;

public class TapBlock extends DirectionalBlock {

    public static final DirectionProperty facing = BlockStateProperties.HORIZONTAL_FACING;

    public TapBlock(Properties p) {
        super(p);
    }



}
