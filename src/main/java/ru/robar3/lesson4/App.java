package ru.robar3.lesson4;

public class App {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        App app = new App();
        Thread thread1 = new Thread(() -> {
            app.print('A');
        });
        Thread thread2 = new Thread(() -> {
            app.print('B');
        });
        Thread thread3 = new Thread(() -> {
            app.print('C');
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void print(char letter) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != letter) {
                        mon.wait();
                    }
                    System.out.print(letter);
                    currentLetter++;
                    if (currentLetter=='D'){
                        currentLetter='A';
                    }
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

