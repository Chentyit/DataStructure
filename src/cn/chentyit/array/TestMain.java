package cn.chentyit.array;

/**
 * @Author Chentyit
 * @Date 2020/3/16 16:00
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) {
        ArrayCty<Integer> arrayCty = new ArrayCty<>(20);
        for (int i = 0; i < 10; i++) {
            arrayCty.addLast(i);
        }
        System.out.println(arrayCty);

        arrayCty.add(1, 100);
        System.out.println(arrayCty);

        arrayCty.addFirst(-1);
        System.out.println(arrayCty);

        System.out.println(arrayCty.remove(2));
        System.out.println(arrayCty);

        System.out.println(arrayCty.removeElement(4));
        System.out.println(arrayCty);

        arrayCty.removeFirst();
        System.out.println(arrayCty);
    }
}
