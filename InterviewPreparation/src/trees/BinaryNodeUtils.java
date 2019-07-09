package trees;

public class BinaryNodeUtils {


    public static BinaryNode insert(BinaryNode root, int data) {
        if(root == null) {
            return new BinaryNode(data);
        } else {
            BinaryNode cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
