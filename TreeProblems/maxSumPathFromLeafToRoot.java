package Algorithms.TreeProblems;

public class maxSumPathFromLeafToRoot {
    static int maxSum = Integer.MIN_VALUE;
    static Node targetLeaf = null;
    static class maxPathLeaf
    {
        int maxLeafSum = Integer.MIN_VALUE;
    } 
    static class Node
    {
        int data;
        Node left, right;
    }

    static Node newNode(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    static void findMaxLeafSum(Node root, int currSum)
    {
        if(root == null)
            return;
        //Add all the current node's data
        currSum = currSum + root.data;
        //We update when the current node is a leaf node
        if(root.left == null && root.right == null)
        {
            if(currSum > maxSum)
            {
                targetLeaf = root;
                maxSum = currSum;
            }
        }
        findMaxLeafSum(root.left, currSum);
        findMaxLeafSum(root.right, currSum);
    }

    static boolean printMaxLeafPath(Node root)
    {
        if(root == null)
            return false;
        
        if(root == targetLeaf || printMaxLeafPath(root.left) || printMaxLeafPath(root.right))
        {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        Node root = newNode(10);
        root.left = newNode(-2); 
        root.right = newNode(7); 
        root.left.left = newNode(8); 
        root.left.right = newNode(-4);

        findMaxLeafSum(root, 0);
        System.out.println(maxSum);
        printMaxLeafPath(root);
    }
}