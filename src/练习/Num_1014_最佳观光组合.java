package 练习;

/**
 * @author mufan
 * @date 2020/6/17
 */
public class Num_1014_最佳观光组合 {
    /**
     * 解题思路：
     * 可以将i看为是静态的,j看为是动态的,当j变化的时候，A[j]-j的值是一定的
     * 因为题目的意思是求A[i]+i+A[j]-j的最大值,所以当j移动的时候只需要求A[i]+[i]的最大值然后不断的更新A[i]+i的最大值
     * res:求res的时候不断的更新res的值
     */
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int preMax = A[0];
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, preMax + A[j] - j);
            preMax = Math.max(preMax, A[j] + j);
        }
        return res;
    }
}
