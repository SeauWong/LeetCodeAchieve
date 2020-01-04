package com.wongcu.concurrent.no1226;

import java.util.concurrent.Semaphore;

/**
 * @author huangsiyao
 * @version 2020/1/3 10:05
 * @since 2020/1/3
 */
public class DiningPhilosophers {

    private Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    private void pickForks(int philosopher, Runnable pickLeftFork, Runnable pickRightFork) throws InterruptedException {
        int right = philosopher % 5;
        int left = (philosopher + 1) % 5;

        if ((philosopher & 1) == 0) {
            forks[right].acquire();
            pickRightFork.run();
            forks[left].acquire();
            pickLeftFork.run();
        } else {
            forks[left].acquire();
            pickLeftFork.run();
            forks[right].acquire();
            pickRightFork.run();
        }
    }

    private void putForks(int philosopher, Runnable putLeftFork, Runnable putRightFork) {
        putRightFork.run();
        forks[philosopher % 5].release();
        putLeftFork.run();
        forks[(philosopher + 1) % 5].release();
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        pickForks(philosopher, pickLeftFork, pickRightFork);
        eat.run();
        putForks(philosopher, putLeftFork, putRightFork);
    }
}
