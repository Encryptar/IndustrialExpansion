package net.Encryptar.IndustrialExpansion.core.init;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.Encryptar.IndustrialExpansion.common.recipes.CompositeSmeltingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeTypeInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IndustrialExpansion.MODID);

    public static final RegistryObject<RecipeSerializer<CompositeSmeltingRecipe>> GEM_CUTTING_SERIALIZER =
            SERIALIZERS.register("composite_smelting", () -> CompositeSmeltingRecipe.Serializer.INSTANCE);

}
