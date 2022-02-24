package net.Encryptar.IndustrialExpansion.common.blocks.TreeSapTap;

import net.Encryptar.IndustrialExpansion.core.init.BlockEntityInit;
import net.Encryptar.IndustrialExpansion.core.init.BlockInit;
import net.Encryptar.IndustrialExpansion.core.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class TapBlockEntity extends BlockEntity {
    public BlockPos neighbour;
    public TapBlockEntity(BlockPos pos, BlockState state){
        super(BlockEntityInit.TREE_SAP_TAP.get(), pos, state);
    }

    public boolean isNextToLog(Level L, BlockPos pos) {
            Direction direction = this.getBlockState().getBedDirection(level, pos);
            switch (direction){
                case EAST:
                    neighbour = pos.east();
                    return L.getBlockState((neighbour)).getBlock() == BlockInit.RUBBER_LOG.get();

                case WEST:
                    neighbour = pos.west();
                    return L.getBlockState((neighbour)).getBlock() == BlockInit.RUBBER_LOG.get();

                case NORTH:
                    neighbour = pos.north();
                    return L.getBlockState((neighbour)).getBlock() == BlockInit.RUBBER_LOG.get();

                case SOUTH:
                    neighbour = pos.south();
                    return L.getBlockState((neighbour)).getBlock() == BlockInit.RUBBER_LOG.get();
            }
            return false;
        }

    public void SpawnSap(Level l){

        BlockPos position = this.getBlockPos();
        double x, y, z;
        x = position.getX();
        y = position.getY();
        z = position.getZ();
        ItemEntity itemEntity = new ItemEntity(l, x, y, z, ItemInit.TREE_SAP.get().getDefaultInstance());
        level.addFreshEntity(itemEntity);
    }
    public void tick(){
        Random ran = new Random();
        //900 is roughly every 45 seconds
        int x = ran.nextInt(900);
        if(isNextToLog(level, this.getBlockPos()) &&
                (x==0)
        ){

            SpawnSap(this.getLevel());
        }
    }
}