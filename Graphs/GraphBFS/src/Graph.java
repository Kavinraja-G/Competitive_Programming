import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    private int V;
    private LinkedList<Integer>[] edges;

    //Constructor:
    Graph(int v)
    {
        this.V = v;
        edges = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            edges[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int el)
    {
        edges[v].add(el);
    }

    void BFS(int start)
    {
        boolean[] visted = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visted[start] = true;
        queue.add(start);

        while (!queue.isEmpty())
        {
            int newVertex = queue.poll();
            System.out.print(newVertex+" ");
            Iterator<Integer> itr = edges[newVertex].listIterator();
            while (itr.hasNext()){
                int newVal = itr.next();
                if(!visted[newVal]) {
                    queue.add(newVal);
                    visted[newVal] = true;
                }
            }
        }
    }

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2);
        G.addEdge(2, 0);
        G.addEdge(2, 3);
        G.addEdge(3, 3);

        //Mention the start vertex
        G.BFS(2);
    }
}
