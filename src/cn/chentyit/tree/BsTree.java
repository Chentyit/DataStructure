package cn.chentyit.tree;

/**
 * @Author Chentyit
 * @Date 2020/3/23 10:53
 * @Description:
 */
public class BsTree<T extends Comparable<T>> {

    private class Node {
        public T t;
        public Node left, right;

        public Node(T t) {
            this.t = t;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BsTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素
     *
     * @param t
     */
    public void add(T t) {
        if (root == null) {
            root = new Node(t);
            size++;
        } else {
            add(root, t);
        }
    }

    /**
     * 向以 node 为根的二分搜索树中插入元素 t，递归算法
     *
     * @param node
     * @param t
     */
    private Node add(Node node, T t) {
        if (node == null) {
            size++;
            return new Node(t);
        }

        if (t.compareTo(node.t) < 0) {
            node.left = add(node.left, t);
        } else if (t.compareTo(node.t) > 0) {
            node.right = add(node.right, t);
        }

        return node;
    }

    /**
     * 查看二分搜索树中是否包含元素 t
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        return contains(root, t);
    }

    public boolean contains(Node node, T t) {
        if (node == null) {
            return false;
        }

        if (t.compareTo(node.t) == 0) {
            return true;
        } else if (t.compareTo(node.t) < 0) {
            return contains(node.left, t);
        } else {
            return contains(node.right, t);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以 node 为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.t);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.t);
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.t);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBsTreeString(root, 0, res);
        return res.toString();
    }

    private void generateBsTreeString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null \n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.t).append("\n");
        generateBsTreeString(node.left, depth + 1, res);
        generateBsTreeString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
