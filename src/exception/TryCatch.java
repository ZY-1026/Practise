package exception;

public class TryCatch {
    public static void main(String[] args) {
        int i = 0;
        try {
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            i++;
            System.out.println(i);
        }
    }
}
