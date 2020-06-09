package 练习;

import 链表.ListNode;

/**
 * @author mufan
 * @date 2020/5/22
 */
public class 面试题22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        //快指针先走,当快指针走到k的时候慢指针再走,最终的结果在慢指针上
        while (fast != null) {
            if (i >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            i++;
        }
        return slow;
    }
}
