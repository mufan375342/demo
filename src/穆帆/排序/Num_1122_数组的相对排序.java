package 穆帆.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mufan
 * @date 2020/7/5
 */
public class Num_1122_数组的相对排序 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);
        list.sort((a, b) -> {
            return a - b;
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];

        int[] temp = new int[1001];
        for (int value : arr1) {
            temp[value]++;
        }
        int index = 0;
        for (int value : arr2) {
            while (temp[value] > 0) {
                res[index++] = temp[value];
                temp[value]--;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                res[index++] = i;
                temp[i]--;
            }
        }
        return res;
    }
}
