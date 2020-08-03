package 每日一题;

/**
 * @author mufan
 * @date 2020/7/8
 */
public class Num_16_11_面试题_跳水板 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        //如果短木板和长木板的长度相同则组成的长度就是 shorter * k
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        //为什么是K+1,是因为都使用短木板的情况下就是k个长度，然后将每一位替换为长木板，当都替换为长木板的时候长度就会+1，这里需要细细品味下
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            //shorter*(k-1)相当于都是用短木板的情况下最长的长度，然后当循环遍历到第二遍的时候就是对短木板进行一个替换的过程
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }
}
