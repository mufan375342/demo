package 链表;

/**
 * @author mufan
 * @time 2019/8/10
 */
public class ListNode {
    public int val;
    public ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
