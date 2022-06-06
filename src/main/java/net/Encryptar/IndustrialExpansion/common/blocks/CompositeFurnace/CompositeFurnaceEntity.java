package net.Encryptar.IndustrialExpansion.common.blocks.CompositeFurnace;

import net.Encryptar.IndustrialExpansion.client.menu.CompositeFurnaceMenu;
import net.Encryptar.IndustrialExpansion.common.recipes.CompositeSmeltingRecipe;
import net.Encryptar.IndustrialExpansion.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;

import static net.Encryptar.IndustrialExpansion.common.blocks.CompositeFurnace.CompositeFurnace.LIT;

public class CompositeFurnaceEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(11){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private int progress = 0;
    private int maxProgress = 20;
    protected final ContainerData data;



    public CompositeFurnaceEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.COMPOSITE_FURNACE.get(), pos, state);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return CompositeFurnaceEntity.this.progress;
                    case 1: return CompositeFurnaceEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: CompositeFurnaceEntity.this.progress = value; break;
                    case 1: CompositeFurnaceEntity.this.maxProgress = value; break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }


    @Override
    public Component getDisplayName() {
        return new TextComponent("Composite Furnace");
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerID, Inventory pInventory, Player player) {
        return new CompositeFurnaceMenu(pContainerID, pInventory, this, this.data);
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("composite_smelting.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("composite_smelting.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, CompositeFurnaceEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.progress > pBlockEntity.maxProgress){
                craftItem(pBlockEntity);
            }
        } else {
            setChanged(pLevel, pPos, pState);
            pBlockEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(CompositeFurnaceEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<CompositeSmeltingRecipe> match = level.getRecipeManager()
                .getRecipeFor(CompositeSmeltingRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
    }

    public static void craftItem(CompositeFurnaceEntity blockEntity){
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<CompositeSmeltingRecipe> match = level.getRecipeManager()
                .getRecipeFor(CompositeSmeltingRecipe.Type.INSTANCE, inventory, level);

        if(match.isPresent()) {
            blockEntity.itemHandler.extractItem(1, 1, false);
            blockEntity.itemHandler.extractItem(2, 1, false);
            blockEntity.itemHandler.extractItem(3, 1, false);
            blockEntity.itemHandler.extractItem(4, 1, false);
            blockEntity.itemHandler.extractItem(5, 1, false);
            blockEntity.itemHandler.extractItem(6, 1, false);
            blockEntity.itemHandler.extractItem(7, 1, false);
            blockEntity.itemHandler.extractItem(8, 1, false);
            blockEntity.itemHandler.extractItem(9, 1, false);

            blockEntity.itemHandler.setStackInSlot(10, new ItemStack(match.get().getResultItem().getItem(),
                    blockEntity.itemHandler.getStackInSlot(10).getCount() + 1));

            blockEntity.resetProgress();
        }

    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(10).getItem() == output.getItem() || inventory.getItem(10).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(10).getMaxStackSize() > inventory.getItem(10).getCount();
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static void burnFuel(CompositeFurnaceEntity blockEntity){
        blockEntity.itemHandler.extractItem(0, 1, false);
    }
}
