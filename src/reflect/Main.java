package reflect;

import java.util.Scanner;

class A{
    static {
        System.out.println("static block");
    }

    {
        System.out.println("dynamic block");
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i){
            case 0:
                Class<?> c = A.class;
                System.out.println("ClassName:" + c.getName());
                break;
            case 1:
                Class<?> c1 = null;
                try{
                    c1= Class.forName("A");
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("ClassName:" + c1.getName());
                break;
            case 2:
                Class<?> c2 = new A().getClass();
                System.out.println("ClassName:" + c2.getName());
                break;
        }
    }
}
