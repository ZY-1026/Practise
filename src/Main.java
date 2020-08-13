
public class Main {
    public static int helper(String s){
        if (s==null || s.length()==0 || s.length() == 1) return 0;
        String tmp = new StringBuilder(s).reverse().toString();
        int count = 0;
        int mid = s.length() >> 1;
        for (int i=0;i<mid;i++){
            if (s.charAt(i) != tmp.charAt(i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(helper("abcd"));
    }
}
