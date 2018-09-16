package learning.javacore;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Locks {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ReadWriteLock redWrite = new ReentrantReadWriteLock();
        Lock writeLock = redWrite.writeLock();
        Lock readLock = redWrite.readLock();


        AtomicInteger atomicInteger = new AtomicInteger(2);
        atomicInteger.addAndGet(5); // в вечном цикле пробуем через нативный метод compareAndSwapInt
        atomicInteger.incrementAndGet();
    }
}
