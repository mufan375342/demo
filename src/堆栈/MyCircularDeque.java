package 堆栈;

/**
 * @author mufan
 * @date 2020/3/22
 */
public class MyCircularDeque {
    /**
     * 使用静态数组,如果涉及的容器大小正好是数组的大小,数据为空和数组满的情况就无法进行区分
     * 所以这时候涉及数组的大小为数组可存放元素的大小+1
     * 因为是循环双端队队列,所以每次的操作只移动指针,所以需要定义两个之怎,一个前一个后
     * 前指针和后指针的初始值都指向0
     * 需要注意的地方是如果是指针向后移动就需要加容器的大小
     * 往前移动的时候无需加数组的大小,直接和数组的大小取模
     */
    private int capacity;
    private int[] arr;
    private int front;
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        // 当 rear 为 0 时防止数组越界
        return arr[(rear - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return front == (rear + 1) % capacity;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        printPermutations(arr, 4, 4);

    }

    public int numRookCaptures(char[][] board) {
        //定义方向，上下左右，（0，1）（0，-1）（-1，0）（1，0）；
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int res = 0;
        //找白色的车
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 'R') {
                    continue;
                }
                //找到了车之后上下左右移动
                for (int[] direction : directions) {
                    //只要不靠近边缘的情况下就一直走，知道找到卒位置
                    int x = i;
                    int y = j;
                    while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                        //如果是友军直接返回，此路不通
                        if (board[x][y] == 'B') {
                            break;
                        }
                        //如果是敌军则拿下
                        if (board[x][y] == 'p') {
                            res += 1;
                            break;
                        }
                        x += direction[0];
                        y += direction[1];
                    }
                }
            }
        }
        return res;
    }

    public static void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            String s = "";
            for (int j = 0; j < data.length; j++) {
                s += " " + data[j];
            }
            System.out.println("----------"+s);

            printPermutations(data, n, k - 1);

            String s1 = "";
            for (int j = 0; j < data.length; j++) {
                s1 += " " + data[j];
            }
            System.out.println("++++++++++"+s1);

            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            String s3 = "";
            for (int j = 0; j < data.length; j++) {
                s3 += " " + data[j];
            }
            System.out.println("############"+s3);
        }
    }


}
