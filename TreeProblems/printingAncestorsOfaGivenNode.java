package TreeProblems;

public class printingAncestorsOfaGivenNode {
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    static Node newNode(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    static boolean printPathHelper(Node root, int key)
    {
        if(root == null)
            return false;
            
        if(root.data == key)
            return true;

        if(printPathHelper(root.left, key) || printPathHelper(root.right, key))
        {
            System.out.print(root.data + " ");
            //This return will help to process all the ancestors that are above the given key!
            return true;
        }
        //Backtrack:
        return false;
    }

    static void printPath(Node root, int key)
    {
        if(!printPathHelper(root, key))
            System.out.println("No common path or key unavailable");
    }

    public static void main(String[] args) {
        /*        1 
                /   \ 
               2     3 
             /  \ 
            4    5 
           / 
          7                     */
        Node root = newNode(1); 
        root.left = newNode(2); 
        root.right = newNode(3); 
        root.left.left = newNode(4); 
        root.left.right = newNode(5); 
        root.left.left.left = newNode(7); 
        int key = 7;
        printPath(root,key);        
    }
}