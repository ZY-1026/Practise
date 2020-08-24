package leetCode.interview1010;

/**
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。
 * 请实现数据结构和算法来支持这些操作，也就是说：
 *
 * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
 *
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 *
 *
 * 示例:
 *
 * 输入:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * 输出:
 * [null,0,null,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-from-stream-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Collections;

public class StreamRank {
    private ArrayList<Integer> list;

    public StreamRank() {
        list = new ArrayList<>(50000);
    }

    public void track(int x) {
        int index = Collections.binarySearch(list, x);
        if (index < 0) index = -index - 1;
        list.add(index, x);
    }

    public int getRankOfNumber(int x) {
        int index = Collections.binarySearch(list, x);
        if (index < 0) index = -index - 1;
        while (index < list.size() && list.get(index) <= x) index++;
        return index;
    }
}
