package net.Encryptar.IndustrialExpansion.world;

import com.google.common.collect.ImmutableList;
import net.Encryptar.IndustrialExpansion.core.init.BlockInit;
import net.Encryptar.IndustrialExpansion.core.init.ItemInit;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.ArrayList;
import java.util.List;
/*
{
  "type": "minecraft:decorated",
  "config": {
    "decorator": {
      "type": "minecraft:count",
      "config": {
        "count": 20
      }
    },
    "feature": {
      "type": "minecraft:decorated",
      "config": {
        "decorator": {
          "type": "minecraft:square",
          "config": {}
        },
        "feature": {
          "type": "minecraft:decorated",
          "config": {
            "decorator": {
              "type": "minecraft:range",
              "config": {
                "height": {
                  "type": "minecraft:uniform",
                  "min_inclusive": {
                    "above_bottom": 0
                  },
                  "max_inclusive": {
                    "absolute": 63
                  }
                }
              }
            },
            "feature": {
              "type": "minecraft:ore",
              "config": {
                "size": 9,
                "discard_chance_on_air_exposure": 0,
                "targets": [
                  {
                    "target": {
                      "predicate_type": "minecraft:tag_match",
                      "tag": "minecraft:stone_ore_replaceables"
                    },
                    "state": {
                      "Name": "industrial_expansion:tin_ore"
                    }
                  },
                  {
                    "target": {
                      "predicate_type": "minecraft:tag_match",
                      "tag": "minecraft:deepslate_ore_replaceables"
                    },
                    "state": {
                      "Name": "industrial_expansion:deepslate_tin_ore"
                    }
                  }
                ]
              }
            }
          }
        }
      }
    }
  }
}

 */
public class WorldGeneration {
    public WorldGeneration(){
    }
    /*public static  void generateOres(final BiomeLoadingEvent e){
        if(!(e.getCategory().equals(Biome.BiomeCategory.NETHER)) || !(e.getCategory().equals(Biome.BiomeCategory.THEEND))){
            e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(new OreFeature(fillerType, state, veinSize)));
        }
    }*/
}