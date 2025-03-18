package me._2818.nocol.client;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class NocolClient implements ClientModInitializer {
    private static final String MOD_VERSION = "1.0.0";
    private static final Identifier CHANNEL = Identifier.of("nocol", "version");

    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> sendModVersion());
    }

    private void sendModVersion() {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        ClientPlayNetworking.send(CHANNEL, buf);
    }
}