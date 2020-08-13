package thread.threadWait;

public class NotifyAllExample {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread_A = new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (resourceA){
                   System.out.println("threadA try to get lock");
                   try{
                       System.out.println("threadA begin wait");
                       resourceA.wait();
                       System.out.println("ThreadA end wait");
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
            }
        }, " Thread_A");

        Thread thread_B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadB try to get lock");
                    try{
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("ThreadB end wait");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread_B");

        Thread thread_C = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("ThreadC begin notify");
                    resourceA.notifyAll();
                }
            }
        }, "Thread_C");

        thread_A.start();
        ;
        thread_B.start();
        Thread.sleep(1000);
        thread_C.start();
        thread_A.join();
        thread_B.join();
        thread_C.join();
    }
}
