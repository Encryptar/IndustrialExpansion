package net.Encryptar.IndustrialExpansion.core.init;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ItemInit {
    private ItemInit(){}
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustrialExpansion.MODID);
    //Items
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> TREE_SAP = ITEMS.register("rubber_tree_sap", () -> new Item(new Item.Properties().tab(IndustrialExpansion.IndustrialExpansionCreativeTab)));
    public static final RegistryObject<Item> RUBBER = ITEMS.register(

    //Block Items
    public static final RegistryObject<BlockItem> TIN_ORE_BLOCKITEM = ITEMS.register("tin_ore", () -> new BlockItem(BlockInit.TIN_ORE.get(),new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> DEEPSLATE_TIN_ORE_BLOCKITEM = ITEMS.register("deepslate_tin_ore", () -> new BlockItem(BlockInit.DEEPSLATE_TIN_ORE.get(),new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_PLANKS = ITEMS.register("rubber_planks",() -> new BlockItem(BlockInit.RUBBER_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_LOG = ITEMS.register("rubber_log",() -> new BlockItem(BlockInit.RUBBER_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> STRIPPED_RUBBER_LOG = ITEMS.register("stripped_rubber_log",() -> new BlockItem(BlockInit.STRIPPED_RUBBER_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_WOOD = ITEMS.register("rubber_wood",() -> new BlockItem(BlockInit.RUBBER_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> STRIPPED_RUBBER_WOOD = ITEMS.register("stripped_rubber_wood",() -> new BlockItem(BlockInit.STRIPPED_RUBBER_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> RUBBER_LEAVES = ITEMS.register("rubber_leaves",() -> new BlockItem(BlockInit.RUBBER_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));




}
