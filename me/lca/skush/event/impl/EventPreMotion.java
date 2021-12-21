package me.lca.skush.event.impl;


import me.lca.skush.event.Event;
import net.minecraft.client.Minecraft;

public class EventPreMotion extends Event {
    public static EventPreMotion getInstance;
    private float yaw;
    private float pitch;

    public EventPreMotion(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
        Minecraft.getMinecraft().thePlayer.renderYawOffset = yaw;
        Minecraft.getMinecraft().thePlayer.rotationYawHead = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
        Minecraft.getMinecraft().thePlayer.prevRotationPitchHead = pitch;
        Minecraft.getMinecraft().thePlayer.rotationPitchHead = pitch;
    }
}