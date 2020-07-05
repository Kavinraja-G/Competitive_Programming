package TreeProblems;
public class CommonNodeFromPathToLCA
{
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

    //First find LCA and find all the common Ancestors of the LCA
    static Node findLCA(Node root, int v1, int v2)
    {
        if(root == null)
            return null;
        
        if(root.data == v1 || root.data == v2)
            return root;
        
        Node leftLCA = findLCA(root.left, v1, v2);
        Node rightLCA = findLCA(root.right,v1,v2);

        if(leftLCA!=null && rightLCA!=null)
            return root;
        return (leftLCA!=null) ? leftLCA : rightLCA;
    }

    static boolean findAncestors(Node root, Node lca)
    {
        if(root == null)
            return false;
        
        //If the lca is root itself
        if(root.data == lca.data)
        {    
            //Print the LCA also because it is also in the path
            System.out.print(root.data+" ");
            return true;
        }

        if(findAncestors(root.left, lca) || findAncestors(root.right, lca))
        {    
            System.out.print(root.data+" ");
            return true;
        }
        return false;
    }

    static boolean findThePath(Node root, int v1, int v2)
    {
        Node LCA = findLCA(root, v1, v2);
        //Corner Case for absence of LCA of two vertices
        if(LCA == null)
            return false; 
        findAncestors(root, LCA);
        return true;
    }
    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2); 
        root.right = newNode(3); 
        root.left.left = newNode(4); 
        root.left.right = newNode(5); 
        root.right.left = newNode(6); 
        root.right.right = newNode(7); 
        root.left.left.left = newNode(8); 
        root.right.left.left = newNode(9); 
        root.right.left.right = newNode(10);
        int v1 = 9;
        int v2 = 7;
        if(findThePath(root, v1, v2)==false)
            System.out.println("NO LCA and NO PATH");
    }
}