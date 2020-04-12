package 练习;

/**
 * @author mufan
 * @date 2020/4/11
 */
public class Num_55_跳跃游戏 {

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] > endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }

    public boolean canJump3(int[] nums) {
        if (nums == null) {
            return false;
        }
        boolean[] temp = new boolean[nums.length];
        temp[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (temp[i]) {
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (j > nums.length - 1) {
                        return true;
                    }
                    temp[j] = true;
                }
            }

        }
        return temp[temp.length - 1];
    }

    // 两层循环，N平方
    public boolean canJump1(int[] nums) {
        if (null == nums) {
            return false;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                return true;
            }
            int num = nums[i];
            //遇到0,判断0前面的数是否能将0绕过
            if (num == 0 && !canJump(nums, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean canJump(int[] nums, int currentZeroPosition) {
        for (int i = currentZeroPosition - 1; i >= 0; i--) {
            //距离必须小于当前数才能将0绕过
            if (currentZeroPosition - i < nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] m = {0, 2, 3};
        Num_55_跳跃游戏 test = new Num_55_跳跃游戏();
        test.canJump3(m);
    }
}
