package search_traverse_tree;
public class Node{
  int data;
  Node left;
  Node right;
  Node(int data){
    this.data=data;
    this.left=null;
    this.right=null;
  }
}
public class bfs_matrix {
public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        if(root==null){
            return null;
        }
      ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int cur=0;
        while(!q.isEmpty()){
            res.add(new ArrayList<>());
            int len=q.size();
            for(int i=0;i<len;i++){
            Node n=q.poll();
            res.get(cur).add(n.data);
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }
            
            }
            cur++;
        }
        return res;
    }
  public static void main(String []args){
    Node root=new Node(1);
    root.left=new Node(2);
     root.right=new Node(3);
     root.right.right=new Node(4);
    root.right.right.left=new Node(6);
    root.right.right.right=new Node(5);
    System.out.println((levelOrder(root));
  }
}
