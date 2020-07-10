package staticTest;

public class Main {

    public Main(){
        System.out.println("Constructor");
    }

    static {
        System.out.println("static");
    }

    {
        System.out.println("block");
    }

    public static void main(String[] args) {
        new Main();
    }
}
