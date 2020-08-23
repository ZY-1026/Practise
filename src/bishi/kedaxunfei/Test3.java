package bishi.kedaxunfei;

import java.util.Scanner;

public class Test3 {
    /**
     * public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
     * return !(rec1[2] <= rec2[0] ||   // left
     * rec1[3] <= rec2[1] ||   // bottom
     * rec1[0] >= rec2[2] ||   // right
     * rec1[1] >= rec2[3]);    // top
     * }
     **/
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) >= Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) >= Math.max(rec1[1], rec2[1]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rec1 = new int[4];
        int[] rec2 = new int[4];
        for (int i = 0; i < 4; i++) {
            rec1[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            rec2[i] = scanner.nextInt();
        }
        int result = isRectangleOverlap(rec1, rec2) == true ? 1 : 0;
        System.out.println(result);
    }
}