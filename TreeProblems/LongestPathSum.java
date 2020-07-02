package TreeProblems;

public class LongestPathSum {
    static int maxLen = 0;
    static int maxSum = 0;
    static class Node
    {
        int data;
        Node left,right;
    }
    static Node newNode(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    static void LongestSumPath(Node root, int currSum, int len)
    {
        if(root == null)
        {
            if(len>maxLen && currSum>maxSum)
            {
                maxLen = len;
                maxSum = currSum;
            }
            return;
        }
        if(len == maxLen && currSum>maxSum)
            maxSum = currSum;
        
        //Now travel recursively along the left child and right child
        LongestSumPath(root.left, currSum+root.data, len+1);
        LongestSumPath(root.right, currSum+root.data, len+1);
    }
    public static void main(String[] args)
    {
        Node root = newNode(4);         /*        4        */
        root.left = newNode(2);         /*       / \       */
        root.right = newNode(5);        /*      2   5      */
        root.left.left = newNode(7);    /*     / \ / \     */
        root.left.right = newNode(1);   /*    7  1 2  3    */
        root.right.left = newNode(2);   /*      /          */
        root.right.right = newNode(3);  /*     6           */
        root.left.right.left = newNode(6);    
        
        LongestSumPath(root, 0, 0);
        System.out.println("Length : "+maxLen+ " Sum :"+maxSum);
    }
}