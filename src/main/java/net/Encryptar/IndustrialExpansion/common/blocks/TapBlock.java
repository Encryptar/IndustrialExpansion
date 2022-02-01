package net.Encryptar.IndustrialExpansion.common.blocks;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.Encryptar.IndustrialExpansion.core.init.BlockInit;
import net.Encryptar.IndustrialExpansion.core.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import java.util.Random;

public class TapBlock extends Block {
    public BlockPos westOffset, eastOffset, northOffset, southOffset;
    public boolean isNextToLog;
    public final DirectionProperty facing = BlockStateProperties.HORIZONTAL_FACING;
    public TapBlock(Properties p) {
        super(p.randomTicks());
    }

    public void isNextToLog(Level L, BlockPos BP) {
            westOffset = BP.west();
            eastOffset = BP.east();
            northOffset = BP.north();
            southOffset = BP.south();
            Block[] blocks = {L.getBlockState((westOffset)).getBlock(), L.getBlockState((eastOffset)).getBlock(),
                L.getBlockState((southOffset)).getBlock(), L.getBlockState((northOffset)).getBlock()};
            for (int i = 0; i<blocks.length; i++){
                if(blocks[i] == BlockInit.RUBBER_LOG.get()){
                    this.isNextToLog = true;
                }
            }
            this.isNextToLog = false;
        }

    @Override
    public void onPlace(BlockState p_60566_, Level p_60567_, BlockPos p_60568_, BlockState p_60569_, boolean p_60570_) {
        super.onPlace(p_60566_, p_60567_, p_60568_, p_60569_, p_60570_);
        this.isNextToLog(p_60567_, p_60568_);
    }

    @Override
    public void tick(BlockState p_60462_, ServerLevel p_60463_, BlockPos p_60464_, Random p_60465_) {
        super.tick(p_60462_, p_60463_, p_60464_, p_60465_);
        if(isNextToLog){
            p_60463_.addFreshEntity(() -> new EntityI(ItemInit.TREE_SAP));
        }
    }
}