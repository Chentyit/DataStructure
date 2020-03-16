package cn.chentyit.array;

/**
 * @Author Chentyit
 * @Date 2020/3/16 11:53
 * @Description:
 */
public class ArrayCty<T> {

    private T[] data;
    private int size;

    /**
     * 构造函数 传入数组的容量 capacity 构造Array
     *
     * @param capacity
     */
    public ArrayCty(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 无参数构造函数 默认容量 capacity = 10
     */
    public ArrayCty() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 在第 index 位置插入一个新的元素 e
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. Require index >= 0 and index <= size");
        }

        if (this.size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取 index 位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改 index 位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素 e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素的索引，找到返回索引，找不到返回 -1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中 index 位置的元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // 让 JVM 回收
        data[size] = null;

        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组中的第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中的元素 e
     *
     * @param e
     */
    public boolean removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
