package TreeProblems;

public class sumofAllNodesWithChildX {

    static int sum = 0;
    static class Node
    {
        int data;
        Node left, right;
    }

    static Node newNode(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    static void sumHelper(Node root, int target)
    {
        if(root == null)
            return;
        if( (root.left!=null && root.left.data == target) || (root.right!=null && root.right.data == target))
            sum += root.data;
        sumHelper(root.left, target);
        sumHelper(root.right, target);
    }


    public static void main(String[] args)
    {
        Node root = newNode(4);
        root.left = newNode(2);
        root.right = newNode(5);
        root.left.left = newNode(7);
        root.left.right = newNode(2);
        root.right.left = newNode(2);
        root.right.left = newNode(3);
        
        int parentSum = 2;
        sumHelper(root, parentSum);
        System.out.println(sum);

    }
}