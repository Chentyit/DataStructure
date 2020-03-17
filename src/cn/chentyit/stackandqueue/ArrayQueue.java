package cn.chentyit.stackandqueue;

import cn.chentyit.array.ArrayCty;

/**
 * @Author Chentyit
 * @Date 2020/3/17 11:44
 * @Description:
 */
public class ArrayQueue<T> implements Queue<T> {

    private ArrayCty<T> array;

    public ArrayQueue(int capacity) {
        array = new ArrayCty<>(capacity);
    }

    public ArrayQueue() {
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

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
