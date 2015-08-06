import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sachin Maheshwari on 8/5/2015.
 */
public class MultiThreadAtomicTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static volatile int counterVolatile = 0;
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        //usingAtomic();
        usingSynchWithVolatile();
        System.out.println(counterVolatile);
        System.out.println(counter);
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void usingSynchWithVolatile() {
        for (int i = 0; i < 1000; i++) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    //lock.lock();
                    try{
                        counterVolatile++;
                    } finally {
                        //lock.unlock();
                    }
                }
            });
            th.start();
        }
    }

    private static void usingAtomic() {
        for (int i = 0; i < 1000; i++) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.getAndIncrement();
                }
            });
            th.start();
        }
    }
}
