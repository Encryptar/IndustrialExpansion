package net.Encryptar.IndustrialExpansion.core.init;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.Encryptar.IndustrialExpansion.common.blocks.CompositeFurnace.CompositeFurnaceEntity;
import net.Encryptar.IndustrialExpansion.common.blocks.TreeSapTap.TapBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, IndustrialExpansion.MODID);

    public static final RegistryObject<BlockEntityType<TapBlockEntity>> TREE_SAP_TAP = BLOCK_ENTITIES.register("tree_sap_tap", () -> BlockEntityType.Builder.of(TapBlockEntity::new, BlockInit.TREE_SAP_TAP.get()).build(null));
    public static final RegistryObject<BlockEntityType<CompositeFurnaceEntity>> COMPOSITE_FURNACE = BLOCK_ENTITIES.register("composite_furnace", () -> BlockEntityType.Builder.of(CompositeFurnaceEntity::new, BlockInit.COMPOSITE_FURNACE.get()).build(null));

    private BlockEntityInit() {
    }
}
