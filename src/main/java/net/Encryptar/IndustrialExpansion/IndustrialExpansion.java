package net.Encryptar.IndustrialExpansion;

import net.Encryptar.IndustrialExpansion.core.init.BlockInit;
import net.Encryptar.IndustrialExpansion.core.init.ItemInit;
import net.Encryptar.IndustrialExpansion.world.WorldGeneration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("industrial_expansion")
public class IndustrialExpansion {
    public static final String MODID = "industrial_expansion";
    public static final CreativeModeTab IndustrialExpansionCreativeTab = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return ItemInit.TIN_ORE_BLOCKITEM.get().getDefaultInstance();
        }
    };
    public IndustrialExpansion() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
    }
}
