package search_traverse_tree;

import java.util.*;

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

public class insertion_and_deletion_bt {
    static Node bt_ins(int arr[]) {
        if (arr.length == 0) {
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (i < arr.length) {
            Node curr = q.poll();
            if (i < arr.length) {
                curr.left = new Node(arr[i++]);
                q.add(curr.left);
            }
            if (i < arr.length) {
                curr.right = new Node(arr[i++]);
                q.add(curr.right);
            }
        }
        return root;

    }

    static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    public static Node Deletion(Node root, int x) {
        if (root == null) {
            return null;
        } // if dletion from leafnode
        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }
        // has child
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node keynode = null;
        Node curr = null;
        while (!q.isEmpty()) {
            curr = q.poll();
            if (curr.data == x) {
                keynode = curr;
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        } // if we found entire subtree of deleting node as keynode
          // swap last node with this last node is curr
        if (keynode != null) {
            int hi = curr.data;
            keynode.data = hi;
            // now we can delete last right node value
            DeepDel(root, curr);
        }
        return root;
    }

    static void DeepDel(Node root, Node curr) {
        Queue<Node> qq = new LinkedList<>();
        qq.add(root);
        while (!qq.isEmpty()) {
            Node cur = qq.poll();
            if (cur == curr) {
                cur = null;
                curr = null;
                return;
            }
            if (cur.left != null) {
                if (cur.left == curr) {
                    cur.left = null;
                    curr = null;
                    return;
                }
                qq.add(cur.left);
            }
            if (cur.right != null) {
                if (cur.right == curr) {
                    cur.right = null;
                    curr = null;
                    return;
                }
                qq.add(cur.right);
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 6, 7, 8, 2 };
        System.out.println("INput" + Arrays.toString(arr));
        Node root = bt_ins(arr);
        Inorder(root);
        Node root_after = Deletion(root, 5);// we replace this node with depest right node here 6
        /*
         * 1
         * / \
         * 5 4
         * / \ / \
         * 2 3 7 8
         * \
         * 6
         */
        System.out.println("\nafter deletion 5");
        Inorder(root_after);
    }
}
