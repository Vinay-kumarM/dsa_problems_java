package search_traverse_tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class binary_search_tree {
    static Node bst_inser(Node root, int num) {
        if (root == null) {
            return new Node(num);
        }
        if (root.data > num) {
            root.left = bst_inser(root.left, num);
        }
        if (root.data < num) {
            root.right = bst_inser(root.right, num);
        }
        return root;
    }

    /*
     * static void printTree(Node root, int space) {
     * // Define the space between levels
     * int spacing = 5;
     * 
     * // Base case
     * if (root == null) {
     * return;
     * }
     * 
     * // Increase distance between levels
     * space += spacing;
     * 
     * // Process the right child first (print higher levels first)
     * printTree(root.right, space);
     * 
     * // Print the current node after spacing
     * System.out.println();
     * for (int i = spacing; i < space; i++) {
     * System.out.print(" ");
     * }
     * System.out.println(root.data);
     * 
     * // Process the left child
     * printTree(root.left, space);
     * }
     */
    static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 4, 3, 6, 8, 9, 2, 10 };
        Node root = null;
        for (int num : nums) {
            root = bst_inser(root, num);
        }
        System.out.println("Tree Structure Before Deletion:");
        // printTree(root, 0);
        Inorder(root);

    }
}
