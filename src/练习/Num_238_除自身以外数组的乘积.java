package 练习;

/**
 * @author mufan
 * @date 2020/6/4
 */
public class Num_238_除自身以外数组的乘积 {
    /**
     * 思路:求除自身以外数组的乘积
     * 1.除了自身外可以分为两个部分
     * 第一个部分是除自身外左边的乘积
     * 第二个部分是除自身外右边的乘积
     * 2.解决该题的时候先求左边的数的乘积
     * 给定一个初始值k，定义一个数组，让数组的第一个元素等于1，因为任何数乘以1都等于1，所以1作为初始值
     * 给定一个数组，然后计算除自身外左边数的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            //这一步的处理是关键,也就是是说计算下一个值的时候前面值的乘积已经计算好了
            k = k * res[i];
        }
        k = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            //这一步是给res进行赋值。如何赋值，就是自身左边的乘积和右边的乘积相城
            res[i] *= k;
            //计算除了自身右边的乘积
            k = k * nums[i];
        }
        return res;
    }
}
