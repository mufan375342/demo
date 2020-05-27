package 练习;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mufan
 * @date 2020/5/27
 */
public class Num_974_和可被K整除的子数组 {
    /**
     * 前缀和
     * 前i到j元素的和
     * (nums[j]-nums[i]) % k = 0
     * 可以说明nums[j] % k = nums[i] % k
     * 也就说明了i到j之间的元素和mok k==0
     * <p>
     * 为什么从第一个元素累加可以？就是因为mok 如果mok到第二个元素的时候为0，那就相当于从第三个元素从新开始mok
     * <p>
     * 为什么需要初始化（0,1） 是因为先要从map中get,并且先计算的是res,map中还未放入元素，所以必须初始化
     * <p>
     * 先放map再计算可以不 ？ 这样是不可以的，比如mok的结果是4这时候res就不应该+1.等到第二次的时候才可以加1.
     * <p>
     * 第一个出现结果为4的地方实际是不纳入结果的，从第二次出现开始就会累加。因为第一个4和第二个4会组成一个合格的区间，第三个4和第二个4也会组成一个合格的区间。第一个和第三个之间也是合理的区间
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int ele : A) {
            sum += ele;
            int module = (sum % K + K) % K;
            Integer same = map.getOrDefault(module, 0);
            res += same;
            map.put(module, same + 1);
        }
        return res;
    }
}
