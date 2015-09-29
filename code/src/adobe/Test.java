package adobe;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class Test {

    private static boolean interruptTask = false;

    private static class MyTask extends Thread {

        public void run() {
            while (!interruptTask) {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    public static void main(String[] args) throws Exception {


        // Start Executing the Long Running Task

        Thread task = new MyTask();

        task.start();


        // Wait for 5 seconds and then interrupt the task

        Thread.sleep(5000L);

        interruptTask = true;


        // Wait for the thread to expire

        task.join();

    }

}


