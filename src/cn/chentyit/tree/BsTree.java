package cn.chentyit.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Pattern;

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
     * 二分搜索树非递归前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.t);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
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

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.t);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return
     */
    public T minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).t;
    }

    /**
     * 返回以 node 为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return
     */
    public T maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).t;
    }

    /**
     * 返回以 node 为根的二分搜索树的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     *
     * @return
     */
    public T removeMin() {
        T ret = minimum();

        removeMin(root);

        return ret;
    }

    /**
     * 删除以 node 为根的二分搜索数中最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在的节点，返回最小值
     *
     * @return
     */
    public T removeMax() {
        T ret = maximum();

        removeMax(root);

        return ret;
    }

    /**
     * 删除以 node 为根的二分搜索数中最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为 t 的节点
     * @param t
     */
    public void remove(T t) {
        root = remove(root, t);
    }

    /**
     * 删除掉以 node 为根的二分搜索树中值为 t 的节点，递归方法
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param t
     * @return
     */
    private Node remove(Node node, T t) {
        if (node ==null) {
            return null;
        }

        if (t.compareTo(node.t) < 0) {
            node.left = remove(node.left, t);
            return node;
        } else if (t.compareTo(node.t) > 0) {
            node.right = remove(node.right, t);
            return node;
        } else {
            // 待删除左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右字数均不为空
            // 找到比待删除节点大的最小节点，即右子树最小节点
            // 用这个节点替换待删除节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
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
