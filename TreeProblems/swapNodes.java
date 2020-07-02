package TreeProblems;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;


public class swapNodes {

    static class Node{
        int data;
        int level;
        Node left,right;
    }

    static Node newNode(int data, int level)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.level = level;
        newNode.left = newNode.right = null;
        return newNode;
    }

    static void inOrder(Node root)
    {
        if(root!=null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    static void swapNode(Node root, int depth)
    {
        if(root == null)
            return;
        
        if(root.level % depth == 0)
        {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        swapNode(root.left, depth);
        swapNode(root.right, depth);
    }

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int level = 1;
        int size = s.nextInt();
        Queue<Node> queue = new LinkedList<Node>();
        Node root = newNode(1,level);
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            int left = s.nextInt();
            int right = s.nextInt();
            Node currNode = queue.poll();
            currNode.left = currNode.right = null;
            if(left != -1)
            {
                currNode.left = newNode(left,currNode.level+1);
                queue.add(currNode.left);
            }
            if(right != -1)
            {
                currNode.right = newNode(right,currNode.level+1);
                queue.add(currNode.right);
            }
        }
        
        int queries = s.nextInt();
        while(queries-- >0)
        {
            int depth = s.nextInt();
            swapNode(root, depth);
            inOrder(root);
            System.out.println("");
        }
    }
}