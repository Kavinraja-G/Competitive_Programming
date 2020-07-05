package TreeProblems;

public class LCA_Finding 
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
    //This works fine for the l1 and l2 are present in the tree O(n)->complexity. To extend this to satisfy the above case we may check for the presence of two 
    //values at first using DFS or just use two static boolean variable and add an extra condition at the return statement.
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
        //Now recursively find the LCA on left and right subtree
        Node leftLCA = findLCA(root.left, l1, l2);
        Node rightLCA = findLCA(root.right, l1, l2);

        if(leftLCA!=null && rightLCA!=null)
            //Current node will be the LCA
            return root;
        
        //Or if any one of the leftLCA or rightLCA is not null then it we be LCA    
        return (leftLCA!=null) ? leftLCA : rightLCA;
    }
    public static void main(String[] args) {
        Node root = newNode(1); 
        root.left = newNode(2); 
        root.right = newNode(3); 
        root.left.left = newNode(4); 
        root.left.right = newNode(5); 
        root.right.left = newNode(6); 
        root.right.right = newNode(7);
        
        Node LCA = findLCA(root,5,7);
        if(l2Status && l1Status)
            System.out.println(LCA.data);
        else if(l1Status)
            System.out.println("Key2 is not present");
        else 
            System.out.println("Key1 is not present");
    }
}

