package cn.chentyit.linklist;

import cn.chentyit.stackandqueue.LoopQueue;

/**
 * @Author Chentyit
 * @Date 2020/3/18 12:22
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
