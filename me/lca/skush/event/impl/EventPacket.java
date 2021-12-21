package me.lca.skush.event.impl;

import me.lca.skush.event.Event;
import net.minecraft.network.Packet;

public class EventPacket extends Event {
    public static EventPacket INSTANCE;
    private Packet packet;

    public EventPacket(Packet packet) {
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
