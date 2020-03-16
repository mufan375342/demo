package 堆栈;

/**
 * 使用数组实现栈
 */
public class ArrayStack {
    /**
     * 数组
     */
    private String[] items;
    /**
     * 占中元素的个数
     */
    private int count;
    /**
     * 栈的大小
     */
    private int n;

    public ArrayStack(String[] items, int count, int n) {
        this.items = items;
        this.count = count;
        this.n = n;
    }

    public boolean push(String item) {
        if (count == n) {
            return false;
        }
        items[count - 1] = item;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String temp = items[count - 1];
        count--;
        return temp;
    }
}
