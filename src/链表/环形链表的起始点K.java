package 链表;

import 链表.ListNode;

/**
 * @author mufan
 * @date 2019/12/20
 */
public class 环形链表的起始点K {
    /**
     * https://segmentfault.com/a/1190000016818496
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //判断链表是否有环
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
