import java.util.LinkedList;

class Graph{
    private int V;
    private LinkedList<Integer>[] edges;
    Graph(int v)
    {
        V = v;
        edges = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            edges[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int e)
    {
        edges[v].add(e);
    }

    void dfsHelper(int vertex, boolean[] visited)
    {
        visited[vertex] = true;
        System.out.print(vertex+" ");
        for (int newVertex : edges[vertex]) {
            if (!visited[newVertex])
                dfsHelper(newVertex, visited);
        }
    }

    void DFS()
    {
        //Default values are false
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) {
            if (!visited[i])
                dfsHelper(i, visited);
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2);
        G.addEdge(2, 0);
        G.addEdge(2, 3);
        G.addEdge(3, 3);
        G.DFS();
    }
}
