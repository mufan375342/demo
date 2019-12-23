package 堆栈;

import java.util.PriorityQueue;

/**
 * @author mufan
 * @date 2019/12/23
 * 优先队列默认的就是小顶堆
 */
public class 数据流中的K大元素 {
    int k;
    PriorityQueue<Integer> priorityQueue;

    /**
     * 第一种实现
     * 因为是需要处理n个元素,每个元素进来之后需要对堆里面的元素进行排序处理，所以每次排序的时间复杂度是logN
     * 整体的复杂度是N*logN
     */
    public 数据流中的K大元素(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }

    public int add(int val) {
        priorityQueue = new PriorityQueue<>(k);
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else {
            int peek = priorityQueue.peek();
            if (peek < val) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }
        return priorityQueue.peek().intValue();
    }
    /**
     * 第二种实现
     * 排序每进来一个元素的时候进行排序，时间复杂度是KlogK,因为需要处理N个元素,所以时间复杂度是N*KlogK
     */
}
