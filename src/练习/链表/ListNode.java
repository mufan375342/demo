package 练习.链表;

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

    /**
     * 分支
     * 1.以数组中的最小元素为分界点
     * 2.最小元素的左边求最大的矩形的面积
     * 3.最小元素的有变求最大的矩形的面积
     * 4.求最大值
     * 时间复杂度：
     * 平均开销：O(nlogn)
     * 最坏情况：O(n^2)
     * 如果数组中的数字是有序的，分治算法将没有任何优化效果。
     * 空间复杂度：O(n)。最坏情况下递归需要 O(n) 的空间。
     */
    public static int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minindex] > heights[i]) {
                minindex = i;
            }
        }
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }

    public static int largestRectangleArea() {
        int[] a = {6, 4, 5, 2, 4, 3, 9};
        return calculateArea(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int i = largestRectangleArea();
        System.out.println(i);
    }
}
