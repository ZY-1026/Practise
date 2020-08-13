package thread.sequencePrint;


public class ThreadRunInTurn1 {
    public static void main(String[] args) {
        final Object object = new Object();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (object) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "  " + i);
                        object.wait();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, " A").start();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "  " + i * (-1));
                    object.notify();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "B").start();
    }
}
