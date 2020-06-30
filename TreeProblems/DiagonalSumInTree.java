package TreeProblems;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalSumInTree {
    //One thing to note to find the diagonal sum is by keeping note the vertical
    //distance vd so that we can able to map the corresponding sums to its diagonal in the map
    static class Node
    {
        int data;
        int vd;
        Node left,right;
    }

    static Node newNode(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.vd = Integer.MAX_VALUE; //Some default value
        newNode.left = newNode.right = null;
        return newNode;
    }

    static void findDiagonalSum(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> levelSum = new TreeMap<>();
        //Initialising the root vd to be '0'
        root.vd = 0;
        queue.add(root);

        while (!queue.isEmpty()) 
        {
            Node currNode = queue.poll();
            int currVD = currNode.vd;
            
            //Now sum all the right childrens
            while(currNode!=null)
            {
                //One thing we need to check is that previous sum should not be zero
                int prevSum = levelSum.get(currVD)==null ? 0 : levelSum.get(currVD);
                levelSum.put(currVD, prevSum + currNode.data);

                if(currNode.left != null)
                {
                    currNode.left.vd = currVD+1;
                    queue.add(currNode.left);
                }
                currNode = currNode.right;
            }
        }
        for(int diagonal: levelSum.keySet())
        {
            System.out.println(diagonal+"--> "+levelSum.get(diagonal));
        }
    }
    public static void main(String[] args)
    {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3); 
        root.left.left = newNode(9); 
        root.left.right = newNode(6); 
        root.right.left = newNode(4); 
        root.right.right = newNode(5); 
        root.right.left.left = newNode(12); 
        root.right.left.right = newNode(7); 
        root.left.right.left = newNode(11); 
        root.left.left.right = newNode(10); 

        findDiagonalSum(root);
    }
    
}