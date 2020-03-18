package cn.chentyit.linklist;

/**
 * @Author Chentyit
 * @Date 2020/3/18 12:22
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
    }
}
