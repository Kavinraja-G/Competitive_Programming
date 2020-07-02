package TreeProblems;
public class sumOfHeightsAllNode {
    static int sum = 0;
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

    static int findheights(Node root)
    {
        if(root == null)
            return 0;

        //Bottom up approach to deal the function
        int leftheight = findheights(root.left);
        int rightheight = findheights(root.right);
        int currHeight = Math.max(leftheight, rightheight) + 1;
        sum += currHeight;
        return currHeight;
    }
    public static void main(String[] args) {
        Node root = newNode(1); 
        root.left = newNode(2); 
        root.right = newNode(3); 
        root.left.left = newNode(4);     
        findheights(root);
        System.out.println(sum);    
    }
}