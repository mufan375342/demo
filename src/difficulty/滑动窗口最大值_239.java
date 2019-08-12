package difficulty;

import javafx.util.Pair;

import java.util.*;

/**
 * @author mufan
 * @time 2019/8/12
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口的最大值
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 */
@SuppressWarnings("all")
public class 滑动窗口最大值_239 {
    /**
     * 滑动窗口最大值
     * 示例:[1,3,-1,-3,5,3,6]
     * k=3
     * 输出:[3,3,5,5,6]
     * 解题思路:
     * 1.滑动窗口,先进来的元素优先出去,这种数据结构相当于队列
     * 2.当窗口达到k个元素的时候必定会选出一个最大值出来,后续每入一个元素都将会存在一个最大值。这时候将最大值保存在result中
     * 3.问题1:当window满的时候如何选取最大的元素？
     * 因为元素都是从右边进入窗口,所以右边的值是动态的,我们可以将window最左边的值保存为最大值
     * 4.问题2:如何将最左边的元素保存为最大值？
     * 每进入一个元素的时候我们可以将即将进入的这个元素和队列中的元素进行比较,将小于其的元素进行剔除,这时候左边的元素就是最大值
     * 为什么要这么做。
     * 例:上面示例中"1"进入窗口之后紧接着就是3进入,当3进入的时候1实际上是没有用的元素,所以将1剔除
     * 5.我们需要保证的是窗口中最多k个元素。当处理到k+1的元素的时候第一个元素必定要出窗口
     */
    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        //定义双端队列
        Deque<Integer> deque = new ArrayDeque<>(k);
        //必定会失去k-1个元素.所以res的长度为nums.length-(k-1)
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty()) {
                //先保证队列中的元素不超过k
                if (i - deque.peek() + 1 > k) {
                    //将第一个元素剔除队列
                    deque.remove();
                }
                //然后将i放入到队列里面.放的时候注意要将比i小的元素剔除
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }
            }
            //每个元素都会进入窗口
            deque.add(i);
            //当窗口进入了k个元素的时候就需要将最大值放入到结果中
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }

    /**
     * 大顶堆
     * 思路：使用优先级队列，队列大小为k，遍历数组将数组元素添加到队列中，如果队列满了那么移除窗口第一个元素，将后一个元素添加到
     * 队列中，如果添加元素后队列满了，那么取出队列的队首元素就是窗口中的最大元素
     */
    private static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() == k) {
                priorityQueue.remove(nums[i - k]);
            }
            priorityQueue.add(nums[i]);
            if (priorityQueue.size() == k) {
                res[i - k + 1] = priorityQueue.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow1(nums, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
