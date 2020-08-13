package finalize;

public class Main {
    public static Main main = null;
    public void isAlive(){
        System.out.println("Yes, I am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalized method executed");
        main = this;
    }

    public static void main(String[] args) throws InterruptedException {
        main = new Main();
        main = null;
        System.gc();
        Thread.sleep(500);
        if(main!=null){
            main.isAlive();
        }else{
            System.out.println("No, I am dead");
        }

        main = null;
        System.gc();
        Thread.sleep(500);
        if(main!=null){
            main.isAlive();
        }else{
            System.out.println("No, I am dead");
        }
    }
}
