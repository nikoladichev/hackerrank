package trees;

/**
 * <a href="https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">BinaryTreeInsert in HackerRank</a>
 */
public class BinaryTreeInsert {

    public static void preOrder(BinaryNode root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void main(String[] args) {

        int[] case1 = {4, 2, 3, 1, 7, 6};

        BinaryNode root = null;
        for (int data : case1) {
            root = insert(root, data);
        }

        preOrder(root);
    }

    private static BinaryNode insert(BinaryNode root, int data) {

        if (root == null) {
            root = new BinaryNode(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }
}
