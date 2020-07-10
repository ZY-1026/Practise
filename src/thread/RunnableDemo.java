package thread;

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable("Run1");
        MyRunnable myRunnable2 = new MyRunnable("Run2");
        MyRunnable myRunnable3 = new MyRunnable("Run3");

        Thread t1 = new Thread(myRunnable1);
        Thread t2 = new Thread(myRunnable2);
        Thread t3 = new Thread(myRunnable3);
        t1.start();
        t2.start();
        t3.start();
    }
}
