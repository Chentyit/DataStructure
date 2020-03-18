package cn.chentyit.linklist;

import cn.chentyit.stackandqueue.Queue;

/**
 * @Author Chentyit
 * @Date 2020/3/18 16:27
 * @Description:
 */
public class LinkedListQueue<T> implements Queue<T> {

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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T t) {
        if (tail == null) {
            tail = new Node(t);
            head = tail;
        } else {
            tail.next = new Node(t);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.t;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur.t).append("->");
        }
        res.append("NULL tail");
        return res.toString();
    }
}
