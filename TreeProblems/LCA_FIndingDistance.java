package TreeProblems;

public class LCA_FIndingDistance 
{
    static boolean l1Status=false, l2Status=false;
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

    static Node findLCA(Node root, int l1, int l2)
    {
        if(root == null)
            return null;
        
        if(root.data == l1 || root.data == l2)
        {
            if(root.data == l1)
                l1Status = true;
            else
                l2Status = true;  
            return root;
        }
        Node leftLCA = findLCA(root.left, l1, l2);
        Node rightLCA = findLCA(root.right, l1, l2);

        if(leftLCA!=null && rightLCA!=null)
            return root;
        return (leftLCA!=null) ? leftLCA : rightLCA;
    }

    static int findLevel(Node root, int value, int depth)
    {
        if(root == null)
            return 0;
        
        if(root.data == value)
            return depth;
        
            //First we check the left subtree
        int left = findLevel(root.left, value, depth+1);
        
        //If it is not present we recur through the right subtree

        if(left == 0)
        //Return the right subtree result so use return the answer recursively
            return findLevel(root.right, value, depth+1);
        return left;
    }

    static int findDistance(Node root,int l1, int l2)
    {
        Node lca = findLCA(root, l1, l2);
        int dl1 = findLevel(lca, l1, 0);
        int dl2 = findLevel(lca, l2, 0);

        return dl1+dl2;
    }

    public static void main(String[] args) {
        Node root = newNode(1); 
        root.left = newNode(2); 
        root.right = newNode(3); 
        root.left.left = newNode(4); 
        root.left.right = newNode(5); 
        root.right.left = newNode(6); 
        root.right.right = newNode(7);
        
        int distance = findDistance(root,4,6);
        System.out.println(distance);
    }
}

