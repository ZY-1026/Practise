package thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExam1 {

    private static final int threadCount = 550;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(300);
        final Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test(threadnum);
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        System.out.println("finished");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum" + threadNum);
        Thread.sleep(1000);
    }
}
