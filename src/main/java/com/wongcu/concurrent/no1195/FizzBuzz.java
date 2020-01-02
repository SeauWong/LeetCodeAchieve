package com.wongcu.concurrent.no1195;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author huangsiyao
 * @version 2020/1/2 20:12
 * @since 2020/1/2
 */
public class FizzBuzz {
    private int n;
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);
    private Semaphore number = new Semaphore(0);
    private volatile boolean finish = false;

    public FizzBuzz(int n) {
        this.n = n;
    }

    private void print(Semaphore s, Runnable printer) throws InterruptedException {
        while(!finish){
            s.acquire();
            if(!finish){
                printer.run();
                number.release();
            }
        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        print(fizz, printFizz);
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        print(buzz, printBuzz);
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        print(fizzbuzz, printFizzBuzz);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<=n; i++){
            if(i % 15 == 0){
                fizzbuzz.release();
                number.acquire();
            }else if(i % 3 == 0){
                fizz.release();
                number.acquire();
            }else if(i % 5 == 0){
                buzz.release();
                number.acquire();
            }else {
                printNumber.accept(i);
            }
        }
        finish = true;
        fizz.release();
        buzz.release();
        fizzbuzz.release();
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(()-> {
            try {
                fizzBuzz.fizz(()-> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(()-> {
            try {
                fizzBuzz.buzz(()-> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(()-> {
            try {
                fizzBuzz.fizzbuzz(()-> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(()-> {
            try {
                fizzBuzz.number((x)-> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown();
    }
}
