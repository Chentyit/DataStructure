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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
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
     * 在链表指定的索引后添加元素
     *
     * @param index
     * @param t
     */
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(t);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(t, prev.next);
        size++;
    }

    /**
     * 链表头插元素
     *
     * @param t
     */
    public void addFirst(T t) {
        add(0, t);
    }

    /**
     * 在链表最后添加节点
     *
     * @param t
     */
    public void addLast(T t) {
        add(size, t);
    }

    /**
     * 获取链表某个索引上的节点
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.t;
    }

    /**
     * 获得链表的第一个元素
     *
     * @return
     */
    public T getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个节点
     *
     * @return
     */
    public T getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表中索引为 index 位置的元素
     * @param index
     * @param t
     */
    public void set(int index, T t) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.t = t;
    }

    /**
     * 查找链表中是否有元素 t
     * @param t
     * @return
     */
    public boolean contains(T t) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.t.equals(t)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除某个位置 index 上的元素
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        return retNode.t;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }
        res.append("NULL");
        return res.toString();
    }
}
