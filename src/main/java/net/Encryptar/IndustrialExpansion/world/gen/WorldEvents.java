package net.Encryptar.IndustrialExpansion.world.gen;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IndustrialExpansion.MODID)
public class WorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        OreGeneration.generateOres(event);
        TreeGeneration.generateTrees(event);
    }
}
