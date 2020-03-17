package cn.chentyit.stackandqueue;

/**
 * @Author Chentyit
 * @Date 2020/3/17 10:33
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
