package com.everything.demo.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FixedThreadPool {
	private static final Logger logger = LoggerFactory.getLogger(FixedThreadPool.class);
    
	private int threadCount;

    private Semaphore semaphore;

    ExecutorService executorService;

    public int getThreadCount() {
        return threadCount;
    }

    public FixedThreadPool(int threadCount, String groupName) {
        this.threadCount = threadCount;
        this.semaphore = new Semaphore(threadCount);
        this.executorService = Executors.newCachedThreadPool(new MessageThreadFactory(groupName, true));
    }

    public void submit(AbstractFixedThread runnable) {
        try {
            semaphore.acquire();
            runnable.setSemaphore(semaphore);
            executorService.submit(runnable);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
