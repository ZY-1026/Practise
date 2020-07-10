package thread;

public class ThreadDemo {

    public static void main(String[] args) {
        Mythread mythread1 = new Mythread("thread1");
        Mythread mythread2 = new Mythread("thread2");
        Mythread mythread3 = new Mythread("thread3");

        mythread1.start();
        mythread2.start();
        mythread3.start();
    }
}
