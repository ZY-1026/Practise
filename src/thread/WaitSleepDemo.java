package thread;

public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() -> {
            System.out.println("thread A is waiting to get lock");
            synchronized (lock) {
                try {
                    System.out.println("thread A get lock");
                    Thread.sleep(20);
                    System.out.println("Thread A do wait object");
                    lock.wait(1000);
                    System.out.println("Thread A is done");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        try{
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("thread B is waiting to get lock");
            synchronized (lock) {
                try {
                    System.out.println("thread B get lock");
                    System.out.println("Thread B is sleeping 10 ms");
                    Thread.sleep(10);
                    System.out.println("Thread B is done");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
