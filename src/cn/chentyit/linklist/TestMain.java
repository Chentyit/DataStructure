package cn.chentyit.linklist;

/**
 * @Author Chentyit
 * @Date 2020/3/18 12:22
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
