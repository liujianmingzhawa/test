package com.everything.demo.common;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractFixedThread implements Runnable{
	 private static final Logger logger = LoggerFactory.getLogger(AbstractFixedThread.class);
    private Semaphore semaphore;

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            semaphore.release();
        }
    }

    public abstract void process() throws Exception;
}
