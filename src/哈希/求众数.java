package 哈希;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mufan
 * @time 2019/8/8
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 求众数
 * 输入: [3,2,3]
 * 输出: 3
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class 求众数 {

    /**
     * 暴力求解
     * 暴力算法遍历整个数组,然后用另一重循环统计每个数组出现的次数，将出现次数最多的元素进行返回
     * 时间复杂度是O(n^2)空间复杂度是O(1)
     */
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return count;
            }
        }
        //没有找到返回-1
        return -1;
    }

    /**
     * hash算法
     * 时间复杂度是O(n),空间复杂度是O(n)
     */
    public int majorityElement1(int[] nums) {
        Integer majorityElement = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majorityElement) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 排序
     * 时间复杂度是O(nlogn)
     * 空间复杂度是O(1)
     */
    public int marjorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 投票算法,时间复杂度是O(n),空间复杂度是O(1)
     * 投票思想：
     * 将第一个值作为被选举的值，将选举的值记为+1,其他值记为-1,然后把他们进行相加,如果和是0,则抛弃前面所有的值
     * 抛弃的值相当于抛弃了同样多的众数和非众数,把下一个值标记为选举值,以此类推
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer temp = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                temp = nums[i];
            }
            count += nums[i] == temp ? 1 : -1;
        }
        return temp;
    }
}
