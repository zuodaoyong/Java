package com.java.thread.pool.custom;

/**
 * 拒绝策略
 */
@FunctionalInterface
public interface RejectPolicy<T> {
    void reject(BlockingQueue<T> blockingQueue,T task);
}
