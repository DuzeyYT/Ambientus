package me.lca.skush.event.impl;

import me.lca.skush.event.Event;

public class EventPreUpdate extends Event {

    private float[] rotation;
    private boolean onGround;

    public EventPreUpdate(float[] rotation, boolean onGround) {
        this.rotation = rotation;
        this.onGround = onGround;
    }

    public float[] getRotation() {
        return rotation;
    }

    public void setRotation(float[] rotation) {
        this.rotation = rotation;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

}