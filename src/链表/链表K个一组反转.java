package 链表;

/**
 * @author mufan
 * @date 2019/12/20
 */
public class 链表K个一组反转 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) {
            return null;
        }
        //定义根节点
        ListNode dump = new ListNode(0);
        //dump指向head
        dump.next = head;
        //定义起始点
        ListNode pre = dump;
        ListNode end = dump;
        while (end.next != null) {
            //确定反转的最后的节点
            for (int i = 0; i < k && end!=null; i++) {
                end = end.next;

            }
            if (end == null) {
                break;
            }
            //未反转的节点
            ListNode next = end.next;
            //待反转的节点
            ListNode start = pre.next;
            end.next = null;
            pre.next = reverse(start);
            //将反转后的和反转前的连起来
            start.next = next;
            //重置pre和end
            pre = start;
            end = pre;
        }
        return dump.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
