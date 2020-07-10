package thread;

public class CycleWait implements Runnable{

    private String value;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread thread =  new Thread(cw);
        thread.start();
//        while(cw.value ==null){
//
//            Thread.currentThread().sleep(100);
//        }
        thread.join();
        System.out.println("value :"  + cw.value);
    }
}
