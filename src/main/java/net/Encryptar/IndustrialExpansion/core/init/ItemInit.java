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
    public static final RegistryObject<Item> example_item = ITEMS.register("example_item", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    //Block Items
    public static final RegistryObject<BlockItem> TIN_ORE_BLOCKITEM = ITEMS.register("tin_ore", () -> new BlockItem(BlockInit.TIN_ORE.get(),new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}
