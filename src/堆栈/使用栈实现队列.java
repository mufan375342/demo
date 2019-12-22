package 堆栈;

import java.util.Stack;

/**
 * @author mufan
 * @date 2019/12/22
 */
public class 使用栈实现队列 {
    private static final Stack<Integer> inStacK = new Stack<>();
    private static final Stack<Integer> outStacK = new Stack<>();

    public void push(int x) {
        inStacK.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStacK.isEmpty()) {
            while (!inStacK.isEmpty()) {
                outStacK.push(inStacK.pop());
            }
        }
        return outStacK.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStacK.isEmpty()) {
            while (!inStacK.isEmpty()) {
                outStacK.push(inStacK.pop());
            }
        }
        return outStacK.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStacK.isEmpty() && outStacK.isEmpty();
    }
}
