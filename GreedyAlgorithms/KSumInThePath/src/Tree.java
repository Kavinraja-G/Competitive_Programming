import java.util.ArrayList;
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
    private static Node root;
    public static  int flag = 0;
    static  void printPaths(Node curr, ArrayList<Integer> path ,int currSum, int sum)
    {
        if(curr == null) {
            return;
        }
        currSum += curr.data;
        path.add(curr.data);
        if(currSum == sum)
        {
            flag = 1;
            for (Integer integer : path) System.out.printf("%d ", integer);
        }

        if(curr.left != null)
            printPaths(curr.left, path, currSum, sum);
        if(curr.right != null)
            printPaths(curr.right, path, currSum, sum);
        path.remove(path.size()-1);
    }

    static void Paths(int sum)
    {
        ArrayList<Integer> path = new ArrayList<>();
        printPaths(root,path,0,sum);
        if(flag==1) System.out.println("true");
        else System.out.println("false");
    }

    public static  void main(String[] args)
    {
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        int sum = 17;
        Paths(sum);

    }
}
