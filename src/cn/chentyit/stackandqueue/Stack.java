package cn.chentyit.stackandqueue;

/**
 * @Author Chentyit
 * @Date 2020/3/17 10:24
 * @Description:
 */
public interface Stack<E> {

    /**
     * 获取栈的大小
     * @return
     */
    int getSize();

    /**
     * 查看栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向栈中压入元素
     * @param e
     */
    void push(E e);

    /**
     * 弹出一个元素
     * @return
     */
    E pop();

    /**
     * 获取栈顶元素
     * @return
     */
    E peek();
}
