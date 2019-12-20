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
            //指针方向后移
            ListNode temp = cur.next;
            //指针反转
            cur.next = pre;
            //反转之后pre和cur的值就会进行变化
            pre = cur;
            cur = temp;
        }
        return pre;
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

    }

}
