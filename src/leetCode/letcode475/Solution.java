package leetCode.letcode475;

import java.util.ArrayList;
import java.util.List;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * <p>
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * <p>
 * 说明:
 * <p>
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 * <p>
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 遍历所有房屋，为其找到离他最近的供暖期
 * 然后返回这些供暖器中最大的一个
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < houses.length; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                int distance = Math.abs((houses[i] - heaters[j]));
                if (distance < tmp) {
                    tmp = distance;
                }
            } // for-1
            list.add(tmp);
        }//for-2
        return max(list);
    }


    public static int max(List<Integer> list) {
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > result) {
                result = list.get(i);
            }
        }
        return result;
    }
}
