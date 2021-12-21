package me.lca.skush.utils;

public final class TimeUtil {
    private long lastMS = 0L;

    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }

    public boolean isDelayComplete(double delay) {
        return System.currentTimeMillis() - this.lastMS >= delay;
    }

    public boolean hasTimeReached(long delay) {
        return System.currentTimeMillis() - lastMS >= delay;
    }

    public long getDelay() {
        return System.currentTimeMillis() - lastMS;
    }

    public void reset() {
        lastMS = getCurrentMS();
    }

    public void setLastMS() {
        lastMS = System.currentTimeMillis();
    }
}
