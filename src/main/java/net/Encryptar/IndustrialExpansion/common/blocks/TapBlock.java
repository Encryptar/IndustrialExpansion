package net.Encryptar.IndustrialExpansion.common.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import javax.annotation.Nullable;

public class TapBlock extends BlockBehaviour {

    public static final DirectionProperty facing = BlockStateProperties.HORIZONTAL_FACING;

    public TapBlock(Properties p) {
        super(p);

    }

    @Override
    public Item asItem() {
        return null;
    }

    @Override
    protected Block asBlock() {
        return null;
    }


}
