package com.everything.demo.common;

import java.util.concurrent.ThreadFactory;

public class MessageThreadFactory implements ThreadFactory {

    private String group;
    private int count = 0;
    private boolean deamon = true;

    public MessageThreadFactory(String group) {
        this.group = group;
    }

    public MessageThreadFactory(String group, boolean deamon) {
        this.group = group;
        this.deamon = deamon;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(new ThreadGroup(group), runnable, String.format("%s-%d", group, count++));
        thread.setDaemon(deamon);
        return thread;
    }
}
