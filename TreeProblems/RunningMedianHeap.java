package Algorithms.TreeProblems;

import java.util.*;

public class RunningMedianHeap {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        
        PriorityQueue<Double> heap = new PriorityQueue<>();
        int size = s.nextInt();
        while(size-- >0)
        {
            heap.add(s.nextDouble());
            Double[] heaparr = new Double[heap.size()];
            Double[] temp = heap.toArray(heaparr);
            System.out.println(heap);
            if(heaparr.length ==1)
            {
                System.out.format("%.1f\n",heaparr[0]);
            }
            else
            {
                if(heaparr.length %2==0)
                {
                    int id = heaparr.length/2;
                    System.out.format("%.1f\n",(heaparr[id-1]+heaparr[id])/2);
                }
                else
                {
                    int id = heaparr.length /2;
                    System.out.format("%.1f\n",heaparr[id]);                   
                }
            }
        }

    }
}
