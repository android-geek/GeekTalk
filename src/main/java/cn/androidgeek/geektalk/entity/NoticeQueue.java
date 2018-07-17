package cn.androidgeek.geektalk.entity;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class NoticeQueue extends LinkedBlockingQueue<Notice> {
    public static final int PULL_TIME = 10;
    public final String session;
    private long lastPull;

    public NoticeQueue(String session) {
        super(1000);
        this.session = session;
        this.lastPull = System.currentTimeMillis();
    }

    public long getLastPull() {
        return this.lastPull;
    }

    public final Notice pull() {
        try {
            this.lastPull = System.currentTimeMillis();
            return poll(PULL_TIME, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
