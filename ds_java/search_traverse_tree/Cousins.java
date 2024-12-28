package search_traverse_tree;

//same parent and same level
class Node {
    int val;
    Node left, right;

    Node(int x) {
        val = x;
        left = right = null;
    }
}

public class Cousins {
    public static boolean isSiblings(Node root, int x, int y) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null && root.left.val == x && root.right.val == y) {
            return true;
        }
        if (root.left != null && root.right != null &&
                root.left.val == y && root.right.val == x)
            return true;

        return isSiblings(root.left, x, y) ||
                isSiblings(root.right, x, y);
    }

    static int sameLevel(Node root, int x, int lev) {
        if (root == null) {
            return -1;
        }
        if (root.val == x) {
            return lev;
        }
        int left = sameLevel(root.left, x, lev + 1);
        if (left != -1) {
            return left;
        }
        return sameLevel(root.right, x, lev + 1);

    }

    static boolean isCousins(Node root, int x, int y) {
        if (!isSiblings(root, x, y) && sameLevel(root, x, 0) == sameLevel(root, y, 0))
            return true;
        return false;

    }

    public static void main(String[] args) {

        // create hard coded tree
        // 1
        // / \
        // 2 3
        // / \
        // 5 4
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        int a = 2, b = 3;

        if (isCousins(root, a, b)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
