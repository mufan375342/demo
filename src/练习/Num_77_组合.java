package 练习;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mufan
 * @date 2020/4/1
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Num_77_组合 {
    static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return res;
        }
        dfs(1, n, k, new ArrayList<>());
        return res;
    }

    private void dfs(int begin, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        //n-k+list.size()+1
        //这里做了剪枝，可以这么理解，加入一共有5和元素，然后组成3个数的组合。
        //当选定了一个元素，即 list.size() == 1 的时候，接下来要选择 2 个元素， i 最大的值是 4 ，因为从 5 开始选择，就无解了；
        //当选定了两个元素，即 list.size() == 2 的时候，接下来要选择 1 个元素， i 最大的值是 5 ，因为从 6 开始选择，就无解了。
        for (int i = begin; i <= n - k + list.size() + 1; i++) {
            list.add(begin);
            dfs(begin + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}
