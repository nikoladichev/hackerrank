package trees;

import java.util.*;

/**
 * See <a href="https://www.hackerrank.com/challenges/tree-level-order-traversal/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">LevelOrderTraversal at HackerRank</a>
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        int[] case1 = new int[]{1, 2, 5, 3, 6, 4};

        BinaryNode root = null;

        for (int value : case1) {
            root = BinaryNodeUtils.insert(root, value);
        }

        levelOrder(root);
    }

    public static void levelOrder(BinaryNode root) {

        List<String> traversedList = new ArrayList<>();
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            BinaryNode currentNode = queue.poll();

            traversedList.add("" + currentNode.data);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        System.out.println(String.join(" ", traversedList));
    }

}
