package cn.chentyit.stackandqueue;

import cn.chentyit.array.ArrayCty;

/**
 * @Author Chentyit
 * @Date 2020/3/17 10:27
 * @Description:
 */
public class ArrayStack<E> implements Stack<E> {

    ArrayCty<E> array;

    public ArrayStack(int capacity) {
        array = new ArrayCty<>(capacity);
    }

    public ArrayStack() {
        array = new ArrayCty<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int gatCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
