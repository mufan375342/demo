package simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mufan
 * @time 2019/8/10
 * 链表是否有环
 */
public class 链表是否有环_141 {
    /**
     * 双指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * hash
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
