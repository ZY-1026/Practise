package nowcoder;


import java.util.PriorityQueue;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * <p>
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * <p>
 * https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=188&&tqId=35164&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking
 */

public class Solution5 {
    /**
     * @param a 数组名称
     * @param n 数组长度
     * @param K 寻找第K大元素
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findKth(a, 0, n - 1, K);
    }

    private int findKth(int[] arr, int low, int high, int K) {
        int index = partition(arr, low, high);
        if (index - low + 1 == K) return arr[index];
        else if (index - low + 1 > K) return findKth(arr, low, index - 1, K);
        else return findKth(arr, index + 1, high, K - index + low - 1);
    }

    /**
     * K之前元素比K大，K之后元素比K小
     *
     * @param a    数组
     * @param low  左侧指针
     * @param high 右侧指针
     * @return
     */
    private int partition(int a[], int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] <= key) high--;
            a[low] = a[high];
            while (low < high && a[low] >= key) low++;
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    // 使用堆实现TopK问题
    private int findKthByHeap(int[] a, int n, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(a[i]);
            if (queue.size() > K) queue.poll();
        }
        return queue.peek();
    }
}
