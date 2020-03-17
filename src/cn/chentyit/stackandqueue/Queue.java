package cn.chentyit.stackandqueue;

/**
 * @Author Chentyit
 * @Date 2020/3/17 11:38
 * @Description:
 */
public interface Queue<T> {

    /**
     * 获取队列长度
     * @return
     */
    int getSize();

    /**
     * 查看队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向队列插入数据
     * @param t
     */
    void enqueue(T t);

    /**
     * 从队列中弹出数据
     * @return
     */
    T dequeue();

    /**
     * 获取队首元素
     * @return
     */
    T getFront();
}
