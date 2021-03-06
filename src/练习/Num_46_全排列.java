package 练习;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mufan
 * @date 2020/4/1
 */
public class Num_46_全排列 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generater(nums, 0, res, new ArrayList<>(), used);
        return res;
    }

    private static void generater(int[] nums, int depth, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            generater(nums, depth + 1, res, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
