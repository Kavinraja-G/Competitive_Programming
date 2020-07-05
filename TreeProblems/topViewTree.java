package TreeProblems;

import java.util.*;
public class topViewTree
{
    static Map<Integer, pair> hashPairs = new TreeMap<>();
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

    static class pair
    {
        int data, level;
        pair ()
        {

        }
        pair(int data, int level)
        {
            this.data = data;
            this.level = level;
        }
    }

    static void fillMapWithViews(Node root, int hd, int level)
    {
        //Base condition
        if(root == null)
            return;
        //If HD is not a key in the map insert it along with the data & level pair of current node
        if(hashPairs.get(hd) == null)
            hashPairs.put(hd, new pair(root.data, level));
        //If key (HD) is already present check if the level of the present node is greater than the current
        //node, if it is then top view will be the current node so replace it
        else if(hashPairs.get(hd).level > level)
            hashPairs.put(hd, new pair(root.data, level));

        //Now recursively itterate through the left and right subtree
        // Left Subtree -> 1) INCREASE LEVEL 2) DECREASE THE HORIZONTAL DISTANCE
        // Right Subtree -> 1) INCREASE LEVEL 2) INCREASE THE HORIZONTAL DISTANCE
        fillMapWithViews(root.left, hd-1, level+1);
        fillMapWithViews(root.right, hd+1, level+1);
    }

    public static void main(String[] args)
    {
        //       1
        //     /   \
        //    2     3
        //     \   
        //       4  
        //         \
        //           5
        //             \
        //              6
        // Horizontal Distances:
        //  1-> 0
        //  2-> -1
        //  3-> 1
        //  4-> 0
        //  5-> 1
        //  6-> 2   The idea is to print the unique and first in HD nodes only with the help of a map
        Node root = newNode(1); 
        root.left = newNode(2); 
        root.right = newNode(3); 
        root.left.right = newNode(4); 
        root.left.right.right = newNode(5); 
        root.left.right.right.right = newNode(6);  
        
        fillMapWithViews(root, 0, 0);

        //Printing the data from the map
        for(int key : hashPairs.keySet())
        {
            System.out.print(hashPairs.get(key).data+" ");
        }
    }
}