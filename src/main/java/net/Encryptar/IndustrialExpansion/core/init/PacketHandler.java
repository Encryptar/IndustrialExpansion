package net.Encryptar.IndustrialExpansion.core.init;

import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler
{
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(IndustrialExpansion.MODID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    private PacketHandler() {
    }

    /*public static void init() {
        int index = 0;
        INSTANCE.messageBuilder(ServerboundTapBlockUpdatePacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(ServerboundTapBlockUpdatePacket::encode).decoder(ServerboundTapBlockUpdatePacket::new)
                .consumer(ServerboundTapBlockUpdatePacket::handle).add();
        INSTANCE.messageBuilder(ClientboundUpdateTapBlockPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(ClientboundUpdateTapBlockPacket::encode).decoder(ClientboundUpdateTapBlockPacket::new)
                .consumer(ClientboundUpdateTapBlockPacket::handle).add();
    }*/
}
