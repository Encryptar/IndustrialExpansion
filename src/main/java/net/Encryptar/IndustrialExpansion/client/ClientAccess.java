package net.Encryptar.IndustrialExpansion.client;

import net.Encryptar.IndustrialExpansion.common.blocks.TreeSapTap.TapBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

    @SuppressWarnings("resource")
    public class ClientAccess {
        public static boolean updateTap(BlockPos pos) {
            final BlockEntity blockEntity = Minecraft.getInstance().level.getBlockEntity(pos);
            if (blockEntity instanceof final TapBlockEntity tapBlock) {
                return true;
            }

            return false;
        }
    }

