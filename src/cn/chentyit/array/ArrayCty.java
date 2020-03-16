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
        size = 0;
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
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }
}
