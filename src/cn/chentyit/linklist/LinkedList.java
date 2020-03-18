package cn.chentyit.linklist;

/**
 * @Author Chentyit
 * @Date 2020/3/18 11:02
 * @Description:
 */
public class LinkedList<T> {

    private class Node {
        public T t;
        public Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this(t, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表头插元素
     *
     * @param t
     */
    public void addFirst(T t) {
//        Node node = new Node(t);
//        node.next = head;
//        head = node;

        head = new Node(t, head);
        size++;
    }

    /**
     * 在链表指定的索引后添加元素
     *
     * @param index
     * @param t
     */
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (index == 0) {
            addFirst(t);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node(t);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(t, prev.next);
            size++;
        }
    }

    /**
     * 在链表最后添加节点
     *
     * @param t
     */
    public void addLast(T t) {
        add(size, t);
    }
}