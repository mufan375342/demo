package 练习.链表;

/**
 * @author mufan
 * @date 2019/12/19
 * 1->2->3->4转换完后为2->1->4->3
 */
public class 链表两两反转 {
    /**
     * 链表两两反转
     * https://juejin.im/post/5da94f6d6fb9a04df10e6ecd
     */
    public ListNode swapPairs(ListNode head) {
        //定义链表的根节点
        ListNode dump = new ListNode(0);
        //根节点指向head
        dump.next = head;
        //为什么要有这么一步，因为指针一直会往后移动，head的节点就会减少
        head = dump;
        while (head.next != null && head.next.next != null) {
            ListNode a = head.next;
            ListNode b = head.next.next;
            head.next = b;
            a.next = b.next;
            b.next = a;
            head = a;
        }
        System.out.println(head.val + "--------------------");
        return dump.next;
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
        链表两两反转 test = new 链表两两反转();
        ListNode result = test.swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        System.out.println("-------------------------------------");
    }
}
