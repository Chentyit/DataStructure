package cn.chentyit.stackandqueue;

/**
 * @Author Chentyit
 * @Date 2020/3/17 10:33
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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
