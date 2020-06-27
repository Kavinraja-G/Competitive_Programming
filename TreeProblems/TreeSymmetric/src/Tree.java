import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

class Node
{
    int data;
    Node left, right;
    Node(int value)
    {
        data = value;
        left = right = null;
    }
}

public class Tree {
    Node root;
    boolean isMirror(Node root1, Node root2)
    {
        if(root1 == null && root2 == null)
            return  true;
        //Check the following to be symmetric:
        //Roots key must be equal
        //left subtree of left == right subtree of right
        //                    &&
        //right subtree of left == left subtree of left
        if(root1!=null && root2!=null && root1.data == root2.data)
        {
            return (isMirror(root1.left, root2.right) && isMirror(root1.right,root2.left));
        }
        return false;
    }
    boolean Symmetric(Node t)
    {
        //Check if the tree is equal to its mirror of itself
        return isMirror(t,t);
    }
    static Scanner s = new Scanner(System.in);
    public static  void main(String[] args)
    {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
    }
}
