package baidu;


public class Test3 {

    public static void main(String[] args) {
        int n = 7;
        int maxStep = 3;
        System.out.println("方案数：" + getStepNum(n, maxStep));
    }

    private static int getStepNum(int n, int m) {
        int sumStep = 0;
        //总台阶数为0时，终止递归循环
        if (n == 0) {
            return 1;
        }
        if (n >= m) {
            //如果n大于每步最大台阶数，则设置第一步为m之内的一个台阶数，然后递归循环
            for (int i = 1; i <= m; i++) {
                sumStep += getStepNum(n - i, m);
            }
        }
        //如果n小于m，则将一步最大台阶数缩小为n，重新递归
        else {
            sumStep = getStepNum(n, n);
        }
        return sumStep % (1000000000 + 7);
    }
}
