package thread;

public class ThreadTest {
    private static void attack(){
        System.out.println("Flight");
        System.out.println("Current main thread 1 :"  + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> attack());
        System.out.println("Current main thread 2:"  + Thread.currentThread().getName());
        //t.run();
        t.start();
    }
}
