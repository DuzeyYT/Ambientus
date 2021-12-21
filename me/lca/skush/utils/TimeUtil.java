package me.lca.skush.utils;

public final class TimeUtil {

    private long lastTime = getCurrentTime();

    public TimeUtil() {
        reset();
    }

    public long getCurrentTime() {
        return System.nanoTime() / 1000000;
    }

    public long getLastTime() {
        return lastTime;
    }

    public long getDifference() {
        return getCurrentTime() - lastTime;
    }

    public void reset() {
        lastTime = getCurrentTime();
    }

    public boolean isDelayComplete(double milliseconds) {
        return getDifference() >= milliseconds;
    }

    public boolean hasTimePassed(long milliseconds) {
        return getDifference() >= milliseconds;
    }

    public void setLastMS() {
        lastTime = System.currentTimeMillis();
    }
}
