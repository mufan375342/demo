package simple;

/**
 * @author mufan
 * @date 2019/12/19
 */
public class 链表反转 {
    /**
     * 反转链表(使用while循环)
     */
    private ListNode reverseList(ListNode head) {
        //为什么将preNode设置为null,是因为preNode头结点的前一个节点就是null
        ListNode pre = null;
        //当前节点
        ListNode cur = head;
        while (cur != null) {
            //指针反转
            cur.next = pre;
            //反转之后pre和cur的值就会进行变化
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }

    /**
     * 反转链表(使用递归)
     */
    private ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head, null);
    }

    private ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        cur.next = pre;
        pre = cur;
        cur = cur.next;
        return reverse(cur, pre);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.next = second;
        second.next = third;
        third.next = forth;
        head.val = 1;
        second.val = 2;
        third.val = 3;
        forth.val = 4;
        链表反转 test = new 链表反转();
        ListNode result = test.reverseList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        System.out.println("-------------------------------------");

        ListNode result2 = test.reverseList2(forth);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }

    }

}
