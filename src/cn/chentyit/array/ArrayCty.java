package cn.chentyit.array;

/**
 * @Author Chentyit
 * @Date 2020/3/16 11:53
 * @Description:
 */
public class ArrayCty {

    private int[] data;
    private int size;

    /**
     * 构造函数 传入数组的容量 capacity 构造Array
     *
     * @param capacity
     */
    public ArrayCty(int capacity) {
        this.data = new int[capacity];
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
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第 index 位置插入一个新的元素 e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (this.size == data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. Require index >= 0 and index <= size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }
}
