package javaconcepts;

import java.util.concurrent.Semaphore;

/**
 * Created by Sachin Maheshwari on 8/7/2015.
 */
public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore available = new Semaphore(1, true);

        available.acquire();

        available.acquire();

        System.out.println(available.availablePermits());

    }
}
