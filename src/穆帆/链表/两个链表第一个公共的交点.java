package 穆帆.链表;

import 练习.链表.ListNode;

/**
 * @author mufan
 * @date 2020/10/20
 */
public class 两个链表第一个公共的交点 {
    /**
     * 两个链表长度分别为L1+C、L2+C， C为公共部分的长度
     * 第一个人走了L1+C步后，回到第二个人起点走L2步；第2个人走了L2+C步后，回到第一个人起点走L1步。 当两个人走的步数都为L1+L2+C时就两个家伙就相爱了
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
