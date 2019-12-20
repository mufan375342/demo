package simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mufan
 * @date 2019/12/20
 */
public class 链表是否有环 {
    /**
     * 链表是否有环(龟兔赛跑)
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 链表是否有环(set集合)
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null) {
            if (set.contains(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        head.next = second;
        second.next = third;
        third.next = second;
        head.val = 1;
        second.val = 2;
        third.val = 3;
        链表是否有环 test = new 链表是否有环();
        boolean b = test.hasCycle(head);
        System.out.println("-------------------------------------" + b);
    }
}
