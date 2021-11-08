package net.Encryptar.IndustrialExpansion.core.init;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ItemInit {
    private ItemInit(){}
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustrialExpansion.MODID);
    //Item Resources
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> TREE_SAP = ITEMS.register("rubber_tree_sap", () -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber", () -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));

    //Crafting Items
    //public static final RegistryObject<BlockItem> COPPER_CABLE = ITEMS.register("copper_cable", () -> new BlockItem(BlockInit.COPPER_CABLE,new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> BASIC_CIRCUIT = ITEMS.register("basic_circuit",() -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));

    //Ores
    public static final RegistryObject<BlockItem> TIN_ORE_BLOCKITEM = ITEMS.register("tin_ore", () -> new BlockItem(BlockInit.TIN_ORE.get(),new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> DEEPSLATE_TIN_ORE_BLOCKITEM = ITEMS.register("deepslate_tin_ore", () -> new BlockItem(BlockInit.DEEPSLATE_TIN_ORE.get(),new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    //Rubber Wood
    public static final RegistryObject<BlockItem> RUBBER_PLANKS = ITEMS.register("rubber_planks",() -> new BlockItem(BlockInit.RUBBER_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_LOG = ITEMS.register("rubber_log",() -> new BlockItem(BlockInit.RUBBER_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> STRIPPED_RUBBER_LOG = ITEMS.register("stripped_rubber_log",() -> new BlockItem(BlockInit.STRIPPED_RUBBER_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_WOOD = ITEMS.register("rubber_wood",() -> new BlockItem(BlockInit.RUBBER_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> STRIPPED_RUBBER_WOOD = ITEMS.register("stripped_rubber_wood",() -> new BlockItem(BlockInit.STRIPPED_RUBBER_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_LEAVES = ITEMS.register("rubber_leaves",() -> new BlockItem(BlockInit.RUBBER_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_SAPLING = ITEMS.register("rubber_sapling",() -> new BlockItem(BlockInit.RUBBER_SAPLING.get(), new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<BlockItem> RUBBER_STAIRS = ITEMS.register("rubber_stairs",() -> new BlockItem(BlockInit.RUBBER_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_SLAB = ITEMS.register("rubber_slab",() -> new BlockItem(BlockInit.RUBBER_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_FENCE = ITEMS.register("rubber_fence",() -> new BlockItem(BlockInit.RUBBER_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_FENCE_GATE = ITEMS.register("rubber_fence_gate",() -> new BlockItem(BlockInit.RUBBER_FENCE_GATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    //Sapphire
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",() -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<BlockItem> SAPPHIRE_BLOCK = ITEMS.register("sapphire_block",() -> new BlockItem(BlockInit.SAPPHIRE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> SAPPHIRE_ORE = ITEMS.register("sapphire_ore",() -> new BlockItem(BlockInit.SAPPHIRE_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> DEEPSLATE_SAPPHIRE_ORE = ITEMS.register("deepslate_sapphire_ore",() -> new BlockItem(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",() -> new SwordItem(ToolInit.GEM, 2, -2.4F,new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",() -> new ShovelItem(ToolInit.GEM, 1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new PickaxeItem(ToolInit.GEM, 1, -2.8F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new AxeItem(ToolInit.GEM, 5.0F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new HoeItem(ToolInit.GEM, -3, 0.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    //Ruby
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",() -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<BlockItem> RUBY_BLOCK = ITEMS.register("ruby_block",() -> new BlockItem(BlockInit.RUBY_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBY_ORE = ITEMS.register("ruby_ore",() -> new BlockItem(BlockInit.RUBY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> DEEPSLATE_RUBY_ORE = ITEMS.register("deepslate_ruby_ore",() -> new BlockItem(BlockInit.DEEPSLATE_RUBY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",() -> new SwordItem(ToolInit.GEM, 2, -2.4F,new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",() -> new ShovelItem(ToolInit.GEM, 1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ToolInit.GEM, 1, -2.8F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(ToolInit.GEM, 5.0F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(ToolInit.GEM, -3, 0.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    //


}
