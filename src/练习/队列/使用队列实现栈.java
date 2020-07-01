package 练习.队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mufan
 * @date 2019/12/22
 */
public class 使用队列实现栈 {
    Queue<Integer> inQueue = new LinkedList<>();
    Queue<Integer> outQueue = new LinkedList<>();

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        inQueue.offer(x);
        while (!outQueue.isEmpty()) {
            inQueue.add(outQueue.poll());
        }
        Queue temp = inQueue;
        inQueue = outQueue;
        outQueue = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return outQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return outQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return outQueue.isEmpty();
    }
}
