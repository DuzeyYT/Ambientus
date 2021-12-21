package me.lca.skush.event.impl;

import me.lca.skush.event.Event;

public class EventChat extends Event {

    private String message;

    public EventChat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
