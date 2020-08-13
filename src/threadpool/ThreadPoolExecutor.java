package threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPoolExecutor {
    private int poolSize;
    private int coreSize = 0;
    private BlockingQueue<Task> blockingQeque;
    private volatile boolean shutdown = false;

    public ThreadPoolExecutor(int poolSize) {
        this.poolSize = poolSize;
        blockingQeque = new LinkedBlockingDeque<>();
    }

    public void execute(Task task) throws InterruptedException {
        if (shutdown == true) return;
        if (task == null) throw new NullPointerException("ERROR：传入的Task为空");
        //如果核心线程数小于线程池容量，将任务加入队列并新建核心线程
        if (coreSize < poolSize) {
            blockingQeque.put(task);
            addWorker(task);
        } else {
            //否则，只将任务加入队列
            blockingQeque.put(task);
        }
    }

    private void addWorker(Task task) {
        Thread thread = new Thread(new Worker());
        thread.start();
        coreSize++;
    }

    public void showdown() {
        shutdown = true;
    }

    class Worker implements Runnable {
        @Override
        public void run() {
            while (!shutdown) {
                try {
                    //循环从队列中取出任务并执行
                    Task task = blockingQeque.take();
                    task.job();
                    System.out.println("taskid = " + task.getId() + " 执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
