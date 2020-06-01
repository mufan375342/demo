package 练习;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mufan
 * @date 2020/6/1
 */
public class Num_1431_拥有最多糖果的孩子 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = -1;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        for (int candy : candies) {
            if ((extraCandies + candy) >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
