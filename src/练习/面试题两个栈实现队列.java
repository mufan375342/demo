package 练习;

import java.util.Stack;

/**
 * @author mufan
 * @date 2020/6/30
 */
public class 面试题两个栈实现队列 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public 面试题两个栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }


    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.empty()) {
            return -1;
        } else {
            return outStack.pop();
        }
    }
}
