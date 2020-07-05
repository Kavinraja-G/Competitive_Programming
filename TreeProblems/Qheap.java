package Algorithms.TreeProblems;
import java.util.ArrayList;
import java.util.Scanner;

public class Qheap {
    static ArrayList<Integer> deleteNode = new ArrayList<>();
    static void insertInHeap(ArrayList<Integer> heap, int data)
    {
        int temp = data, i = heap.size();
        heap.add(temp);
        while(i>1 && temp<heap.get(i/2))
        {
            heap.set(i, heap.get(i/2));
            i /= 2;
        }
        heap.set(i,temp);
    }

    static void deleteFromHeap(ArrayList<Integer> heap, int data)
    {
        while(heap.size()>=2 && deleteNode.contains(heap.get(1)))
        {
            //Boundary Check
            if(heap.size()==2 && data==heap.get(1))
            {
                heap.remove(heap.size()-1);
                return;
            }
            int i = 1, j = 2*i;
            int last = heap.get(heap.size()-1);
            heap.set(1, last);
            while(j < heap.size()-1)
            {
                //Compare with the childs which we need to move to the parent
                if(heap.get(j+1) < heap.get(j))
                    j = j + 1; //Move to the right child so if it is less we can swap
                if(heap.get(i) > heap.get(j))
                {
                    int temp = heap.get(i);
                    heap.set(i, heap.get(j));
                    heap.set(j, temp);
                    i = j;
                    j = i*2;
                }
                else
                    break;
            }
            heap.remove(heap.size()-1);
        }
    }

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {

        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(0);
        int queries = s.nextInt();
        while(queries-- > 0)
        {
            int op = s.nextInt();
            switch(op)
            {
                case 1:
                {
                    int data = s.nextInt();
                    insertInHeap(heap,data);
                    break;
                }
                case 2:
                {
                    int data = s.nextInt();
                    deleteNode.add(data);
                    deleteFromHeap(heap,data);
                    break;
                }
                case 3:
                {
                    System.out.println(heap);
                    System.out.println(heap.get(1));
                    break;
                }
                default:
                    break;
            }
        }
    }
}