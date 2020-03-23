package cn.chentyit.tree;

/**
 * @Author Chentyit
 * @Date 2020/3/23 12:06
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        BsTree<Integer> bst = new BsTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums) {
            bst.add(num);
        }

        bst.preOrder();
        System.out.println();

        System.out.println(bst);
    }
}
