package TreeProblems;

public class sumOfLeftLeafs {

    static int leftSum = 0;
    static int rightSum = 0;
    
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

    static void findLeftLeafSum(Node root)
    {
        if(root == null)
            return;
        if(root.left!=null && root.left.left == null && root.left.right == null)
            leftSum += root.left.data;
        findLeftLeafSum(root.left);
        findLeftLeafSum(root.right);
    }

    static void findRightLeafSum(Node root)
    {
        if(root == null)
            return;
        if(root.right!=null && root.right.left == null && root.right.right == null)
            rightSum += root.right.data;
        findRightLeafSum(root.left);
        findRightLeafSum(root.right);
    }
    public static void main(String[] args)
    {
        Node root = newNode(20); 
        root.left = newNode(9); 
        root.right = newNode(49); 
        root.left.right = newNode(12); 
        root.left.left = newNode(5); 
        root.right.left = newNode(23); 
        root.right.right = newNode(52); 
        root.left.right.right = newNode(12); 
        root.right.right.left = newNode(50);
        findLeftLeafSum(root);
        findRightLeafSum(root);
        System.out.println("Left Leaf Sum:"+ leftSum);
        System.out.println("Right Leaf Sum:"+ rightSum);
    }
}