package 练习;

import 练习.链表.ListNode;

import java.util.Stack;

/**
 * @author mufan
 * @date 2020/4/14
 */
public class Num_445_两个数之和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int temp = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || temp > 0) {
            int sum = temp;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            temp = sum / 10;
        }
        return head;
    }
}
