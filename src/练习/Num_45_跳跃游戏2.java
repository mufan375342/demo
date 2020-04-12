package 练习;

/**
 * @author mufan
 * @date 2020/4/12
 */
public class Num_45_跳跃游戏2 {
    /**
     * 顺藤摸瓜
     * 1.记录当前能跳跃的边界
     * 2.找出能跳出最远距离的元素
     * 3.每次从可以调到最大距离的元素开始跳，并且步数+1
     * <p>
     * 这里要注意一个细节，就是 for 循环中，i < nums.length - 1，少了末尾。因为开始的时候边界是第 0 个位置，
     * steps 已经加 1 了。如下图，如果最后一步刚好跳到了末尾，此时 steps 其实不用加 1 了。
     * 如果是 i < nums.length，i 遍历到最后的时候，会进入 if 语句中，steps 会多加 1。
     */
    public int jump(int[] nums) {
        //记录能够跳跃的边界
        int end = 0;
        //最远的距离
        int maxposition = 0;
        //步数
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxposition = Math.max(maxposition, nums[i] + i);
            if (i == end) {
                end = maxposition;
                step++;
            }
        }
        return step;
    }

    /**
     * 顺瓜摸藤
     */
    public int jump1(int[] nums) {
        int res = 0;
        int position = nums.length - 1;
        //从前往后找能到达最后一个元素的位置，找到之后更新position,然后res+1,不断的重复此过程,知道position=0
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (position - i <= nums[i]) {
                    position = i;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
