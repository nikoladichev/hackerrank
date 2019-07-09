package trees;

import java.util.Arrays;

/**
 * See <a href="https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees">BinaryTreeHeight at HackerRank</a>
 */
public class BinaryTreeHeight {

    public static void main(String[] args) {

        BinaryNode case1 = new BinaryNode(3);
        Arrays.asList(5, 2, 1, 4, 6, 7).forEach(i -> BinaryNodeUtils.insert(case1, i));

        System.out.println(height(case1)); // 3

        BinaryNode case2 = new BinaryNode(15);
        System.out.println(height(case2)); // 0

        BinaryNode case3 =  new BinaryNode(3);
        Arrays.asList(1, 7, 5, 4).forEach(i -> BinaryNodeUtils.insert(case3, i));
        System.out.println(height(case3)); // 3

    }

    public static int height(BinaryNode root) {

        int leftHeight = maxHeight(root.left, 0);
        int rightHeight = maxHeight(root.right, 0);

        return leftHeight > rightHeight ? leftHeight : rightHeight;

    }

    public static int maxHeight(BinaryNode node, int height) {

        if (node == null) return height;

        height++;

        if (node.left == null && node.right == null) {
            return height;
        }

        int leftHeight = height;
        if (node.left != null) {
            leftHeight = maxHeight(node.left, height);
        }

        int rightHeight = height;
        if (node.right != null) {
            rightHeight = maxHeight(node.right, height);
        }

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}
