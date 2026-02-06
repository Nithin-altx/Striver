import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class BinaryTree {

    static Scanner sc = new Scanner(System.in);

    static void insertnode(Node root) {
        if (root == null) return;

        System.out.println("Want to Enter to Left Of " + root.val);
        int a = sc.nextInt();

        if (a == 1) {
            System.out.println("Enter the Value to Left Of " + root.val);
            int val = sc.nextInt();
            Node newnode1 = new Node(val);
            root.left = newnode1;
            insertnode(newnode1);
        }
        System.out.println("Want to Enter to Right Of " + root.val);
        int b = sc.nextInt();

        if (b == 1) {
            System.out.println("Enter the Value to Right Of " + root.val);
            int val = sc.nextInt();
            Node newnode2 = new Node(val);
            root.right = newnode2;
            insertnode(newnode2);
        }
    }
    static void preorder(Node root,ArrayList<Integer> ls)
    {
        if(root==null)
        return;

        ls.add(root.val);
        preorder(root.left, ls);
        preorder(root.right, ls);
    }
     static void inorder(Node root,ArrayList<Integer> ls)
    {
        if(root==null)
        return;
 
        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
    }
      static void postorder(Node root,ArrayList<Integer> ls)
    {
        if(root==null)
        return;
 
        postorder(root.left, ls);
        postorder(root.right, ls);
        ls.add(root.val);
        
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        insertnode(root);
        ArrayList<Integer> ls=new ArrayList<>();
        inorder(root,ls);
        for(int x:ls)
        {
            System.out.print(x+" ");
        }
    }
}
