package ru.robar3.lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private CountDownLatch downLatch;
    private String name;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    CyclicBarrier cyclicBarrier;
    Semaphore semaphore;
    public Car(Race race, int speed, CyclicBarrier countDownLatch, Semaphore semaphore, CountDownLatch downLatch) {
        this.race = race;
        this.speed = speed;
        this.downLatch = downLatch;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier =countDownLatch;
        this.semaphore=semaphore;
    }
    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            downLatch.countDown();
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }


        for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
        }

        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}