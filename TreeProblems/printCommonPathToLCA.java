package Algorithms.TreeProblems;

import java.util.ArrayList;

public class printCommonPathToLCA {
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


    static boolean pathHelper(Node root, Node lca, ArrayList<Integer> path) 
    {
        if(root == null)
            return false;

        path.add(root.data);
        if(root == lca)
            return true;

        if(pathHelper(root.left, lca, path) || pathHelper(root.right, lca, path))
        {
            return true;
        }

        //Now backtrack by removing the last inserted node
        path.remove(path.size()-1);
        return false;
    }

    static void printCommonPath(Node root, int v1, int v2)
    {
        Node lca = findLCA(root, v1, v2);
        ArrayList<Integer> path = new ArrayList<>();
        //If root is the LCA no common path exists so return 
        if(root == lca)
        {
            System.out.println("No common path");
            return;
        }
        pathHelper(root, lca, path);
        for(int el: path)
        {
            System.out.print(el+" ");
        }
    }

    public static void main(String[] args) {
        Node root = newNode(1);  
        root.left = newNode(2);  
        root.right = newNode(3);  
        root.left.left = newNode(4);  
        root.left.right = newNode(5);  
        root.right.left = newNode(6);  
        root.right.right = newNode(7);  
        root.left.right.left = newNode(8);  
        root.right.left.right = newNode(9);
        int v1 = 4;
        int v2 = 8;   
        printCommonPath(root, v1, v2);
    } 
}