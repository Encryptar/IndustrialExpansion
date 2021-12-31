package net.Encryptar.IndustrialExpansion.world.gen;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.Encryptar.IndustrialExpansion.core.init.BlockInit;
import net.Encryptar.IndustrialExpansion.core.init.ItemInit;
import net.Encryptar.IndustrialExpansion.world.structures.RubberTreeGrower;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class TreeGeneration {
    public static final List<ConfiguredFeature<?, ?>> OVERWORLD_TREES = new ArrayList<>();
    public static final List<ConfiguredFeature<?, ?>> END_TREES = new ArrayList<>();
    public static final List<ConfiguredFeature<?, ?>> NETHER_TREES = new ArrayList<>();

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> CF) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialExpansion.MODID, name), CF);
    }

    public static final ConfiguredFeature<TreeConfiguration, ?> RUBBER_TREE =
            register("rubber", Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(BlockInit.RUBBER_LOG.get().defaultBlockState()),
                    new StraightTrunkPlacer(5, 2, 0),
                    new SimpleStateProvider(BlockInit.RUBBER_LEAVES.get().defaultBlockState()),
                    new SimpleStateProvider(BlockInit.RUBBER_SAPLING.get().defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));

    @Mod.EventBusSubscriber(modid = IndustrialExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber {
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent e) {
            ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, e.getName());
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
            if(types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.SWAMP)) {
                List<Supplier<ConfiguredFeature<?, ?>>> base = e.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
                base.add(() -> TreeGeneration.RUBBER_TREE
                        .decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED)
                        .decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(2, 0.1f, 1))));
            }
        }
    }
}
