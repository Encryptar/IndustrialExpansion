package net.Encryptar.IndustrialExpansion.core.init;

import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;

public class RecipeTypeInit {
    public static final DeferredRegister<RecipeSerializer<CompositeSmelting>> COMPOSITE_CRAFTING = RecipeSerializer.register("composite_smelting", () -> new SpecialRecipeBuilder(CompositeSmelting::new));
}
