package adobe;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class Queue<T> {

    private final Object[] elementData;
    private int currentPointer;
    Condition notEmpty;
    Condition notFull;
    Lock lock;

    public Queue(int size) {
        elementData = new Object[size];
        currentPointer = -1;
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public void add(T element) throws InterruptedException {
        lock.lock();
        try {
            while (queueIsFull()){
                notFull.await();
            }
            addElement(element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    private void addElement(T element) {
        elementData[++currentPointer] = element;

    }

    private boolean queueIsFull() {
        return currentPointer == elementData.length - 1;
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (queueIsEmpty()){
                notEmpty.await();
            }
            T object = removeFromQueue();
            notFull.signal();
            return object;
        } finally {
            lock.unlock();
        }

    }

    private T removeFromQueue() {
        Object o = elementData[0];
        // adjust the elements now
        for (int i = 0; i < currentPointer; i++) {
            elementData[i] = elementData[i+1];
        }
        elementData[currentPointer] = null;
        currentPointer--;
        return (T) o;

    }

    private boolean queueIsEmpty() {
        return currentPointer == -1;
    }


    @Override
    public String toString() {
        return "Queue{" +
                "elementData=" + Arrays.toString(elementData) +
                ", currentPointer=" + currentPointer +
                '}';
    }


    public static void main(String[] args) throws InterruptedException {
        final Queue<Integer> queue = new Queue<>(2);

        Thread producer = new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Adding into the queue");
                        queue.add(1);
                        Thread.sleep(2000L);
                        System.out.println("Added");
                        System.out.println(queue);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread consumer = new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Removing from the queue");
                        queue.remove();
                        Thread.sleep(5000L);

                        System.out.println("Removed");
                        System.out.println(queue);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        consumer.start();
        producer.start();

        consumer.join();
        producer.join();


    }
}
