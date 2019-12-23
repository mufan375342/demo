package 堆栈;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mufan
 * @date 2019/12/23
 */
public class 大顶堆的实现 {
    //大顶堆实现的时候实际上是自己需要实现comparator
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
}
