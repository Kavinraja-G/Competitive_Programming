package Algorithms.TreeProblems;

import java.util.PriorityQueue;
import java.util.Scanner;


public class JesseAndCookies {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(0);
        int n = s.nextInt();
        int k = s.nextInt();
        int count = 0;
        for(int i=0;i<n;i++)
        {
            heap.add(s.nextInt());
        }
        while (heap.size()>1 && heap.peek()<k) {
            int first = heap.poll();
            int second = heap.poll();
            heap.add(first+(2*second));
            count++;
        }
        if(heap.peek() < k)
        {    
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }
}