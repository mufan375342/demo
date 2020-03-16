package 堆栈;

/**
 * @author mufan
 * @date 2020-03-16
 */
public class LLQuene {
    class Node {
        private int date;
        private Node next;

        public Node(int date) {
            this.date = date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getDate() {
            return date;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    class LLQueue {
        private Node frontNode;
        private Node rearNode;

        public LLQueue() {   //构造函数
            this.frontNode = null;
            this.rearNode = null;
        }

        public boolean isEmpty() {   //判断是否为空
            return (frontNode == null);
        }

        public void enQueue(int date) {  //入队
            Node newNode = new Node(date);
            if (rearNode != null) {
                rearNode.setNext(newNode);
            }
            rearNode = newNode;
            if (frontNode == null) {
                frontNode = rearNode;
            }
        }

        public int deQueue() {   //出队
            int date = 0;
            if (frontNode != null) {
                date = frontNode.getDate();
                frontNode = frontNode.getNext();
            } else {
                System.out.println("Queue Empty");
            }
            return date;
        }
    }

}
