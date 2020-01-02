package com.wongcu.concurrent.no1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangsiyao
 * @version 2020/1/2 11:31
 * @since 2020/1/2
 */
public class Foo {

    private volatile int nextCount = 1;

    public Foo() {

    }

    private void orderPrint(int expect, Runnable runnable){
        while ( nextCount != expect){
        }
        runnable.run();
        nextCount++;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        orderPrint(1, printFirst);
    }

    public void second(Runnable printSecond) throws InterruptedException {
       orderPrint(2, printSecond);
    }

    public void third(Runnable printThird) throws InterruptedException {
        orderPrint(3, printThird);
    }
}