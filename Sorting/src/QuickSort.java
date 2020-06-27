import java.util.Collections;
import java.util.Scanner;

public class QuickSort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int l, int h)
    {
        int pivot = arr[l];
        int i = l, j = h;
        do {
            do{i++;}while (arr[i]<=pivot);
            do{j--;}while (arr[j]>pivot);
            if(i<j)
            {
                swap(arr, i, j);
            }
        }while (i<j);
        swap(arr,l,j);
        return j;
    }
    static void Sort(int[] arr, int l, int h)
    {
        int j;
        if(l<h)
        {
            j = partition(arr,l,h);
            Sort(arr, l, j);
            Sort(arr,j+1,h);
        }
    }
    static Scanner s = new Scanner(System.in);
    public static  void main(String[] args)
    {
        int size = s.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)
            arr[i] = s.nextInt();
        Sort(arr,0,size-1);
        for (int i=0; i<size;i++)
            System.out.println(arr[i]);
    }

}
