package com.ambientus.api;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;

public class PacketUtil {
    public static void sendPacketSilentMC(Packet packet) {
        Minecraft.getMinecraft().thePlayer.sendQueue.getNetworkManager().sendPacket(packet, null, null);
    }

    public static void sendPacketSilent(Packet packet) {
        Minecraft.getMinecraft().getNetHandler().getNetworkManager().sendPacket(packet, null, null);
    }

    public static void sendPacketMC(Packet packet) {
        Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(packet);
    }

    public static void sendPacket(Packet packet) {
        Minecraft.getMinecraft().getNetHandler().addToSendQueue(packet);
    }
}
