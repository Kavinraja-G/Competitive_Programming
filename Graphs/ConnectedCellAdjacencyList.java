package Algorithms.Graphs;

import java.util.*;

public class ConnectedCellAdjacencyList {
    static class Graphs{
        int V;
        LinkedList<Integer>[] edgesList;
        public Graphs(int v)
        {
            this.V = v;
            edgesList = new LinkedList[v];
            for(int i=0;i<v;i++)
                edgesList[i] = new LinkedList<>();
        }

        public void addEdge(int src, int des)
        {
            edgesList[src].add(des);
            edgesList[des].add(src);
        }

        public void dfsHelper(int vertex, boolean[] visited)
        {
            System.out.print(vertex+" ");
            visited[vertex] = true;
            for(int el : edgesList[vertex])
            {
                if(!visited[el])
                    dfsHelper(el, visited);
            }
        }

        public void dfs()
        {
            boolean[] visited = new boolean[V];
            for(int i=0;i<V;i++)
            {
                dfsHelper(i, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();
        Graphs graph = new Graphs(row);
        int[][] adjList = new int[row][col];
        for(int i=0; i<row; i++)
        {
            for(int j=0;j<col;j++)
            {
                adjList[i][j] = s.nextInt();
                if(adjList[i][j]==1)
                    graph.addEdge(i, j);
            }
        }
        graph.dfs();
        s.close();
    }
}