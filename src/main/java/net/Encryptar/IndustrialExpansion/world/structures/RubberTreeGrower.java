package net.Encryptar.IndustrialExpansion.world.structures;

import net.Encryptar.IndustrialExpansion.world.gen.TreeGeneration;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nullable;
import java.util.Random;

public class RubberTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<ConfiguredFeature<TreeConfiguration, ?>> getConfiguredFeature(Random p_60014_, boolean p_60015_) {
        return TreeGeneration.RUBBER_TREE;
    }
}
