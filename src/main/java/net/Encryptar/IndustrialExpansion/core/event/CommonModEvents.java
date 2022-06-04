package net.Encryptar.IndustrialExpansion.core.event;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.Encryptar.IndustrialExpansion.client.menu.CompositeFurnaceScreen;
import net.Encryptar.IndustrialExpansion.common.recipes.CompositeSmeltingRecipe;
import net.Encryptar.IndustrialExpansion.core.init.BlockInit;
import net.Encryptar.IndustrialExpansion.core.init.MenuInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = IndustrialExpansion.MODID, bus = Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
    }
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        event.enqueueWork(() -> {ItemBlockRenderTypes.setRenderLayer(BlockInit.RUBBER_SAPLING.get(), RenderType.cutout());});
        MenuScreens.register(MenuInit.COMPOSITE_FURNACE_MENU.get(), CompositeFurnaceScreen::new);
    }

    @SubscribeEvent
    public static void registerRecipeTpypes(final RegistryEvent.Register<RecipeSerializer<?>> event){
        Registry.register(Registry.RECIPE_TYPE, CompositeSmeltingRecipe.Type.ID, CompositeSmeltingRecipe.Type.INSTANCE);
    }
}
