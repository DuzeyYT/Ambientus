package me.lca.skush.event.impl;


import me.lca.skush.event.Event;
import net.minecraft.network.Packet;

public abstract class EventCancellable extends Event {




    private Packet packet;
    private boolean cancelled;

    protected EventCancellable() {
    }
    public Packet getPacket() {
        return this.packet;
    }
    /**

     */

    public boolean isCancelled() {
        return cancelled;
    }

    /**

     */

    public void setCancelled(boolean state) {
        cancelled = state;
    }
}