package search_traverse_tree;

class Node {
    Node left;
    Node right;
    char data;

    Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class huffman_coding {
    static boolean helper(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
    }

    static void decode(String s, Node root) {
        StringBuilder sb = new StringBuilder();
        Node curr = root;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (helper(curr.left)) {
                    sb.append(curr.left.data);
                    curr = root;
                } else {
                    curr = curr.left;
                }
            } else {
                if (c == '1') {
                    if (helper(curr.right)) {
                        sb.append(curr.right.data);
                        curr = root;
                    }

                    else {
                        curr = curr.right;
                    }
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Node root = new Node('5');
        root.left = new Node('A');
        root.right = new Node('6');
        root.right.left = new Node('R');
        root.right.right = new Node('4');
        root.right.right.right = new Node('B');
        root.right.right.left = new Node('2');
        root.right.right.left.left = new Node('C');
        root.right.right.left.right = new Node('D');
        String s = "01111001100011010111100";// ABRACADABRA
        decode(s, root);
    }
}
