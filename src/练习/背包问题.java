package 练习;

/**
 * @author mufan
 * @date 2020/4/24
 * 对于一组不同重量、不可分割的物品,我们需要选择一些装入背包,在满足背包最大重量限制的前提下,背包中物品总重量的最大值是多少呢？
 */
public class 背包问题 {

    private static int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private static int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量

    /**
     * *************************************************************回溯************************************************
     * 1.要将物品放入背包,每个物品只有一个,但是重量可能相同
     * 2.背包有最大的承受重量
     * 每个物品都可以放入和不放入背包两种选择,所以递归可以解决,可以想象下递归树
     */


    public static void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了,i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }

    /**
     * *************************************************************回溯+备忘录************************************************
     * 回溯解的时候递归树上有重复节点,这时候我们需要将重复的节点进行去除
     */
    public static void f1(int i, int cw) {
        boolean[][] flag = new boolean[n][weight.length + 1];

        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw;
            return;
        }

        if (flag[i][cw]) return;
        flag[i][cw] = true;

        f(i + 1, cw);

        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]);
        }
    }

    /**
     * *************************************************************动态规划************************************************
     * 横坐标为物品的个数,纵坐标为物品的重量
     */
    public static int f3(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][weight.length + 1];
        states[0][0] = true;
        if (weight[0] < w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            //第i个物品不放入
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            //第i个放入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * *************************************************************动态规划空间优化************************************************
     * 横坐标为物品的个数,纵坐标为物品的重量
     */
    public static int f4(int[] weight, int n, int w) {
        boolean[] states = new boolean[weight.length + 1];
        states[0] = true;
        if (weight[0] < w) {
            states[weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            //第i个放入背包
            //这里我特别强调一下代码中的第 8 行,j 需要从大到小来处理。如果我们按照 j 从小到大处理的话,会出现 for 循环重复计算的问题(最终的重量也不对,比如有两个物品,重量分别为1和5,然后背包是 6)
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * *************************************************************背包升级版,求最大的价值,回溯************************************************
     */
    private int maxV = Integer.MIN_VALUE; // 结果放到maxV中
    private int[] value = {3, 4, 8, 9, 6}; // 物品的价值

    public void f(int i, int cw, int cv) { // 调用f(0, 0, 0)
        if (cw == w || i == n) { // cw==w表示装满了,i==n表示物品都考察完了
            if (cv > maxV) maxV = cv;
            return;
        }
        f(i + 1, cw, cv); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i], cv + value[i]); // 选择装第i个物品
        }
    }

    /**
     * *************************************************************背包升级版,求最大的价值,动态规划************************************************
     */

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划,状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第i个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }
}
