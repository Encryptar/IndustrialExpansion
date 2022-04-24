package net.Encryptar.IndustrialExpansion.core.event;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.Encryptar.IndustrialExpansion.core.init.BlockInit;
import net.Encryptar.IndustrialExpansion.world.gen.OreGeneration;
import net.Encryptar.IndustrialExpansion.world.gen.TreeGeneration;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = IndustrialExpansion.MODID, bus = Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
    }
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        event.enqueueWork(() -> {ItemBlockRenderTypes.setRenderLayer(BlockInit.RUBBER_SAPLING.get(), RenderType.cutout());});
    }
}
