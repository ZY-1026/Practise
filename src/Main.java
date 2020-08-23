

public class Main extends Thread {
    private int x = 2;

    public static void main(String[] args) throws Exception {
        new Main().makeltSo();
    }

    public Main() {
        x = 5;
        start();
    }

    public void makeltSo() throws Exception {
        this.join();
        x = x - 1;
        System.out.println(x);
    }

    public void run() {
        x *= 2;
    }

}
