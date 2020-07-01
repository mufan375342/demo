package 练习.队列;

import java.util.*;

/**
 * @author mufan
 * @date 2019/12/23
 */
public class 滑动窗口的最大值 {
    /**
     * 使用队列的方式
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        //定义双端队列
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) {
                //如果队列为空则放入队列中
                deque.add(i);
            } else {
                //如果队列不为空,放入队列之前必须保证队列里面一共有三个元素
                if (i - k + 1 > deque.peek()) {
                    deque.remove();
                }
                //放入的时候需要判断队列为不为空并且移除小的值(移除的时候需要特别的注意)
                while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                    deque.removeLast();
                }
                //放入值
                deque.offer(i);
            }
            //如果k=3的时候也就是说从第三个元素(下标为2)开始的时候就必须选出一个值出来,这时候队列最左边就是最大的值
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }

    /**
     * 使用堆的方式
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() == k) {
                priorityQueue.remove(nums[i - k]);
            }
            priorityQueue.offer(nums[i]);
            if (priorityQueue.size() == k) {
                res[i - k + 1] = priorityQueue.peek();
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int[] ints = maxSlidingWindow1(nums, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
