package cn.androidgeek.geektalk;

import cn.androidgeek.geektalk.entity.NoticeQueue;

import java.util.HashMap;

public class UserTable {
    public static final CleanThread CLEAN_THREAD = new CleanThread();
    public static final HashMap<String, NoticeQueue> users = new HashMap<>();

    public static class CleanThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (UserTable.class) {
                    for (String key : users.keySet()) {
                        if (users.get(key).getLastPull() + 3 * 60 * 1000 < System.currentTimeMillis()) {
                            users.put(key, null);
                        }
                    }
                }
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
