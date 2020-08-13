package thread.sequencePrint;


public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":1");
            }
        }, "thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println(Thread.currentThread().getName() + ":2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    System.out.println(Thread.currentThread().getName() + ":3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
