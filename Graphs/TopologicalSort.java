package Algorithms.Graphs;

import java.util.*;

public class TopologicalSort
{
    static class Graph
    {
        int V;
        LinkedList<Integer> [] edgeList;
        public Graph(int v)
        {
            this.V = v;
            edgeList = new LinkedList[v];
            for(int i=0;i<v;i++)
                edgeList[i] = new LinkedList<>();
        }
        
        public void addEdge(int source, int destination)
        {
            edgeList[source].add(destination);
        }
        //To print the vertices in the topological order we need a stack and perform dfs
        //on all its adjacent edges and print it's source before its edges

        public void printTopological()
        {
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<V;i++)
            {
                if(!visited[i])
                    dfs(i, visited, stack);
            }
            while(!stack.isEmpty())
                System.out.print(stack.pop()+" ");
        }

        public boolean dfs(int i, boolean[] visited, Stack<Integer> stack)
        {
            if(visited[i])
                return false;
            
            visited[i] = true;
            for(int adj : edgeList[i])
            {
                if(!visited[adj])
                    dfs(adj, visited, stack);
                //At return of all the edges now push the elements into the stack
                //so that at the time of pop we get all the elements in topological order
            }
            stack.push(i);
            return false;
        }
    }
	public static void main(String[] args) {
		Graph g1 = new Graph(6); 
        g1.addEdge(5, 2); 
        g1.addEdge(5, 0); 
        g1.addEdge(4, 0); 
        g1.addEdge(4, 1); 
        g1.addEdge(2, 3); 
        g1.addEdge(3, 1); 
        /*
        	5 -> 2 -> 3 -> 1 , 5 -> 0
        	4 -> 1 -> , 4 -> 0    
        */
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g1.printTopological();
    }
}