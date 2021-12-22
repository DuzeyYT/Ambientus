package me.lca.skush.event.impl;


import net.minecraft.network.Packet;

public class EventReceivedPacket extends EventCancellable {
    public static EventReceivedPacket INSTANCE;
    private Packet packet;

    public EventReceivedPacket(Packet packet) {
        INSTANCE = this;
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {

        this.packet = packet;

    }
}
