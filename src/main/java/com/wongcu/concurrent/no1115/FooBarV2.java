package com.wongcu.concurrent.no1115;

/**
 * @author huangsiyao
 * @version 2020/1/2 13:58
 * @since 2020/1/2
 */
public class FooBarV2 {
    private int n;
    private volatile boolean isFoo = true;

    public FooBarV2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(!isFoo){
                Thread.yield();
            }
            printFoo.run();
            isFoo = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while(isFoo){
                Thread.yield();
            }
            printBar.run();
            isFoo = true;
        }
    }

    public static void main(String[] args) {
        FooBarV2 fooBar = new FooBarV2(100);
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
