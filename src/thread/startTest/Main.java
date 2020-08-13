package thread.startTest;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1111);
                System.out.println(Thread.currentThread().getName());
            }
        }, "Thread-1");
        try {
//            thread.start();
//            thread.start();  // IllegalThreadStateException
            thread.start();
            System.out.println( Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
