package net.Encryptar.IndustrialExpansion.world.gen;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.Encryptar.IndustrialExpansion.core.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OreGeneration {
    public static final List<ConfiguredFeature<?, ?>> OVERWORLD_ORES = new ArrayList<>();
    public static final List<ConfiguredFeature<?, ?>> END_ORES = new ArrayList<>();
    public static final List<ConfiguredFeature<?, ?>> NETHER_ORES = new ArrayList<>();

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> CF) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialExpansion.MODID, name), CF);
    }

    public static void registerOres(){
        ConfiguredFeature<?,?> tinOre = Feature.ORE.configured(
                new OreConfiguration(List.of(
                        OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BlockInit.TIN_ORE.get().defaultBlockState()),
                        OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, BlockInit.DEEPSLATE_TIN_ORE.get().defaultBlockState())
                        ), 8)).rangeUniform(VerticalAnchor.bottom(),VerticalAnchor.aboveBottom(96)).squared().count(20);
        OVERWORLD_ORES.add(register("tin_ore",tinOre));
    }

    @Mod.EventBusSubscriber(modid =IndustrialExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber{
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent e){
            List<Supplier<ConfiguredFeature<?,?>>> OreFeatures = e.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
            switch (e.getCategory()){
                case NETHER -> OreGeneration.NETHER_ORES.forEach(ore -> OreFeatures.add(() -> ore));
                case THEEND -> OreGeneration.END_ORES.forEach(ore -> OreFeatures.add(() -> ore));
                default -> OreGeneration.OVERWORLD_ORES.forEach(ore -> OreFeatures.add(() -> ore));
            }
        }

    }


}
