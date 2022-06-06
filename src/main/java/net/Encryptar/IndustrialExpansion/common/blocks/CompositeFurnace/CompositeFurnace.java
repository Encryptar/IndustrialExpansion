package net.Encryptar.IndustrialExpansion.common.blocks.CompositeFurnace;

import net.Encryptar.IndustrialExpansion.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CompositeFurnace extends BaseEntityBlock {
    private static final Property<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static  final BooleanProperty LIT = BooleanProperty.create("lit");

    public CompositeFurnace(BlockBehaviour.Properties properties){
        super(properties);
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext Context) {
        return this.defaultBlockState().setValue(FACING, Context.getHorizontalDirection().getOpposite()).setValue(LIT, false);
    }

    public BlockState setLit(BlockState state){
        return state.setValue(LIT, true);
    }

    @Override
    public BlockState rotate(BlockState State, Rotation Rotation) {
        return State.setValue(FACING, Rotation.rotate(State.getValue(FACING)));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState mirror(BlockState State, Mirror pMirror) {
        return State.rotate(pMirror.getRotation(State.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LIT);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CompositeFurnaceEntity) {
                ((CompositeFurnaceEntity) blockEntity).drops();
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!level.isClientSide()){
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof CompositeFurnaceEntity){
                NetworkHooks.openGui((ServerPlayer) player, (CompositeFurnaceEntity) entity, pos);
            } else {
                throw new IllegalStateException("Our Container provider is missing");
            }
        }


        return super.use(state, level, pos, player, hand, hitResult);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CompositeFurnaceEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, BlockEntityInit.COMPOSITE_FURNACE.get(), CompositeFurnaceEntity::tick);
    }

    public void animateTick(BlockState p_53635_, Level p_53636_, BlockPos p_53637_, Random p_53638_) {
        if (p_53635_.getValue(LIT)) {
            double d0 = (double)p_53637_.getX() + 0.5D;
            double d1 = (double)p_53637_.getY();
            double d2 = (double)p_53637_.getZ() + 0.5D;
            if (p_53638_.nextDouble() < 0.1D) {
                p_53636_.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = p_53635_.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = p_53638_.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
            double d6 = p_53638_.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
            p_53636_.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            p_53636_.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    }


}
