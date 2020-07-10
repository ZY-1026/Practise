package thread.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private static final int CAPACITY = 5;
    private static final Lock lock = new ReentrantLock();
    private static final Condition fullCondition = lock.newCondition();
    private static final Condition emptyCondition = lock.newCondition();

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Thread producer1 = new Producer("P1", queue, CAPACITY);
        Thread producer2 = new Producer("P2", queue, CAPACITY);
        Thread consumer1 = new Consumer("C1", queue, CAPACITY);
        Thread consumer2 = new Consumer("C2", queue, CAPACITY);
        Thread consumer3 = new Consumer("C3", queue, CAPACITY);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

    public static class Producer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                // acquire lock
                lock.lock();
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, Producer[" + name + "] thread waiting for " + "consumer to take something from queue.");
                        fullCondition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } // while
                System.out.println("[" + name + "] Producing value : +" + i);
                queue.offer(i++);
                fullCondition.signalAll();
                emptyCondition.signalAll();
                lock.unlock();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } // while
        } // run
    }


    public static class Consumer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;

        public Consumer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                //获得锁
                lock.lock();
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                        //队列为空满足条件，消费者线程阻塞
                        emptyCondition.await();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                int x = queue.poll();
                System.out.println("[" + name + "] Consuming value : " + x);
                //唤醒其他所有生产者、消费者
                fullCondition.signalAll();
                emptyCondition.signalAll();
                //释放锁
                lock.unlock();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
