package me.lca.skush.event.impl;

import me.lca.skush.event.Event;
import net.minecraft.network.Packet;

public class EventPacket extends Event {
    private Packet packet;

    public EventPacket(Packet packet) {
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}
