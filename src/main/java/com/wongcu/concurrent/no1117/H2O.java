package com.wongcu.concurrent.no1117;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author huangsiyao
 * @version 2020/1/3 10:41
 * @since 2020/1/3
 */
public class H2O {

    private Semaphore h = new Semaphore(4);
    private Semaphore o = new Semaphore(2);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire(2);
        releaseHydrogen.run();
        o.release(1);

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        releaseOxygen.run();
        h.release(4);
    }

    public static void main(String[] args) {
        Runnable releaseHydrogen = ()-> System.out.println("H");
        Runnable releaseOxygen = ()-> System.out.println("O");

        H2O h2O = new H2O();
        Runnable hydrogen = ()-> {
            try {
                h2O.hydrogen(releaseHydrogen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable oxygen = ()-> {
            try {
                h2O.oxygen(releaseOxygen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(9);
        executor.execute(oxygen);
        executor.execute(oxygen);
        executor.execute(oxygen);
        executor.execute(hydrogen);
        executor.execute(hydrogen);
        executor.execute(hydrogen);
        executor.execute(hydrogen);
        executor.execute(hydrogen);
        executor.execute(hydrogen);
        executor.shutdown();
    }
}
