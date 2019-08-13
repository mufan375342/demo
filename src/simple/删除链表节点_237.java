package simple;

/**
 * @author mufan
 * @time 2019/8/10
 */
public class 删除链表节点_237 {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
