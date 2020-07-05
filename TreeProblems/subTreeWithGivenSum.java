package TreeProblems;

public class subTreeWithGivenSum {
    static int count = 0;
    static Node rootRef = new Node();
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

    static int findSubtreeSumUtil(Node root, int sum)
    {
        if(root == null)
            return 0;
        
        int ls = findSubtreeSumUtil(root.left, sum);
        int rs = findSubtreeSumUtil(root.right, sum);
        int currSum = ls + rs + root.data;
        if(currSum == sum)
            count++;
        //Return the current sum to add it with root where it is first called
        return currSum;
    }

    static int findSubtreeSum(Node root, int sum)
    {
        if(root == null)
            return 0;
        
        int ls = findSubtreeSumUtil(root.left, sum);
        int rs = findSubtreeSumUtil(root.right, sum);

        if(ls + rs + root.data == sum)
            count++;
        return count;
    }

    static int subTreeSumCount(Node root, int sum)
    {
        int ls = 0, rs = 0;
        if(root == null)
            return 0;
        ls += subTreeSumCount(root.left, sum);
        rs += subTreeSumCount(root.right, sum);

        if(ls+rs+root.data == sum)
            count++;
        //This is a bottom up approach so recursively travel in the tree until the 
        //control reaches the top of the root

        if(rootRef != root)
            return ls+root.data+rs;
        else
            return count;
    }

    public static void main(String[] args) {
        Node root = newNode(5);  
        root.left = newNode(-10);  
        root.right = newNode(3);  
        root.left.left = newNode(9);  
        root.left.right = newNode(8);  
        root.right.left = newNode(-4);  
        root.right.right = newNode(7);
        rootRef = root;
        int sum = 7;
        //findSubtreeSum(root, sum);        ->This method takes O(n^2)
        subTreeSumCount(root, sum);       //->This takes O(n)
        System.out.println(count);
    }
}