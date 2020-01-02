package com.wongcu.concurrent.no1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangsiyao
 * @version 2020/1/2 13:58
 * @since 2020/1/2
 */
public class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private volatile boolean isFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if(!isFoo){
                fooCondition.await();
            }
            printFoo.run();
            isFoo = false;
            barCondition.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(isFoo){
                barCondition.await();
            }
            printBar.run();
            isFoo = true;
            fooCondition.signal();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(100);
        new Thread(()->{
            try {
                fooBar.foo(() -> {
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fooBar.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
