package net.Encryptar.IndustrialExpansion.core.init;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.Encryptar.IndustrialExpansion.common.blocks.TapBlock;
import net.Encryptar.IndustrialExpansion.world.structures.RubberTreeGrower;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class BlockInit {
    private BlockInit(){}
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IndustrialExpansion.MODID);
    //Ores
    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = BLOCKS.register("deepslate_tin_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)));
    //Rubber Wood
    public static final RegistryObject<Block> RUBBER_PLANKS = BLOCKS.register("rubber_planks",() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RUBBER_LOG = BLOCKS.register("rubber_log",() -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> RUBBER_WOOD = BLOCKS.register("rubber_wood",() -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_RUBBER_LOG = BLOCKS.register("stripped_rubber_log",() -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_RUBBER_WOOD = BLOCKS.register("stripped_rubber_wood",() -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> RUBBER_LEAVES = BLOCKS.register("rubber_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> RUBBER_SAPLING = BLOCKS.register("rubber_sapling", () -> new SaplingBlock(new RubberTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).instabreak().noOcclusion()));
    public static final RegistryObject<Block> RUBBER_STAIRS = BLOCKS.register("rubber_stairs",() -> new StairBlock(() -> RUBBER_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> RUBBER_SLAB = BLOCKS.register("rubber_slab",() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> RUBBER_FENCE = BLOCKS.register("rubber_fence",() -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> RUBBER_FENCE_GATE = BLOCKS.register("rubber_fence_gate",() -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    //Utility Blocks
    //public static final RegistryObject<TapBlock> TREE_SAP_TAP = BLOCKS.register("tree_sap_tap",() -> new TapBlock(BlockBehaviour.Properties.of(Material.METAL)));
    //public static final RegistryObject<Block> COPPER_CABLE = BLOCKS.register("copper_cable",() -> new (BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    //Sapphire
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block",() -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore",() -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = BLOCKS.register("deepslate_sapphire_ore",() -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE)));
    //Ruby
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",() -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore",() -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore",() -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE)));

}

