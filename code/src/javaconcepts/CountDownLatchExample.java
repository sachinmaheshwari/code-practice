package javaconcepts;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sachin Maheshwari on 8/7/2015.
 */
public class CountDownLatchExample {

    public static void main(String[] args) {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();
                        System.out.println("got the start signal");
                        Thread.sleep(1000);
                        System.out.println("done");
                        doneSignal.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        try {
            Thread.sleep(3000);
            System.out.println("Sending start signal");
            startSignal.countDown();
            System.out.println("Waiting for done");
            doneSignal.await();
            System.out.println("all done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
