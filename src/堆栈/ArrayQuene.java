package 堆栈;

/**
 * 把它想象成排队买票，先来的先买，后来的人只能站末尾，不允许插队。先进者先出
 */
public class ArrayQuene {
    private String[] items;
    private int n;
    private int head;
    private int tail;

    public ArrayQuene(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队操作，将item放入队尾
    public boolean enqueue(String item) {
        // tail == n表示队列末尾没有空间了
        if (tail == n) {
            // tail ==n && head==0，表示整个队列都占满了
            if (head == 0) return false;
            // 数据搬移
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    private String deQuene(String item) {
        if (head == tail) {
            return null;
        }
        String temp = items[head];
        head++;
        return temp;
    }

    /**
     * 循环数组
     */
    public class CircularQueue {
        // 数组：items，数组大小：n
        private String[] items;
        private int n = 0;
        // head表示队头下标，tail表示队尾下标
        private int head = 0;
        private int tail = 0;

        // 申请一个大小为capacity的数组
        public CircularQueue(int capacity) {
            items = new String[capacity];
            n = capacity;
        }

        // 入队
        public boolean enqueue(String item) {
            // 队列满了
            if ((tail + 1) % n == head) return false;
            items[tail] = item;
            tail = (tail + 1) % n;
            return true;
        }

        // 出队
        public String dequeue() {
            // 如果head == tail 表示队列为空
            if (head == tail) return null;
            String ret = items[head];
            head = (head + 1) % n;
            return ret;
        }
    }
}
