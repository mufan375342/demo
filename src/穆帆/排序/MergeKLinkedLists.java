package 穆帆.排序;

import 练习.链表.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mufan
 * @date 2020/7/2
 */
public class MergeKLinkedLists {
    /**
     * 小顶堆
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode currentNode = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            currentNode.next = queue.poll();
            currentNode = currentNode.next;
            if (currentNode.next != null) {
                queue.add(currentNode.next);
            }
        }
        return dummy.next;
    }

    /**
     * 归并排序
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (right - left) / 2 + left;
        ListNode l1 = merge(lists, 0, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoList(l1, l2);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l2.next, l1);
            return l2;
        }
    }
}
