package cn.chentyit.linklist;

import cn.chentyit.stackandqueue.Stack;

/**
 * @Author Chentyit
 * @Date 2020/3/18 16:20
 * @Description:
 */
public class LinkedListStack<T> implements Stack<T> {

    private LinkedList<T> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T t) {
        list.addFirst(t);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
