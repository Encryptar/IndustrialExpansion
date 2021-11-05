package net.Encryptar.IndustrialExpansion;

import net.Encryptar.IndustrialExpansion.core.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("industrial_expansion")
public class IndustrialExpansion {
    public static final String MODID = "industrial_expansion";

    public IndustrialExpansion() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);
    }
}
