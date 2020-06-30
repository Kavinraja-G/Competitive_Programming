package TreeProblems;

class Solution{
    static class Node
    {
        int data;
        Node left, right;
    }

    static Node newNode(int data){
        //Create a Node class instance
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    static int sumofAllNodes(Node root)
    {
        if(root == null)
            return 0;
        return (root.data + sumofAllNodes(root.left) + sumofAllNodes(root.right));
    }

    public static void main(String[] args)
    {
        //Creating a tree manually
        Node root = newNode(1);
        root.left = newNode(2);  
        root.right = newNode(3);  
        root.left.left = newNode(4);  
        root.left.right = newNode(5);  
        root.right.left = newNode(6);  
        root.right.right = newNode(7);  
        root.right.left.right = newNode(8);     
        
        //Finding the sum of all nodes 
        int sum = sumofAllNodes(root);
        System.out.println(sum);
    }
}