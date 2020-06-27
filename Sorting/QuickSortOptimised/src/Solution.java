import java.util.Scanner;
public class Solution {
    static void swap(int[] arr, int a, int b)
    {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
    static int partition(int[] arr, int l, int r)
    {
        int pivot = arr[l];
        int i = l;
        int j = r;
        do {
            do {
                i++;
            }while (arr[i] <= pivot);
            do {
                j--;
            }while (arr[j]>pivot);
            if(i<j)
            {
                swap(arr, i, j);
            }
        }while (i<j);
        swap(arr, l, j);
        return j;
    }
    static void Quicksort(int[] arr, int l,int r)
    {
        if(l<r)
        {
            int j = partition(arr, l, r);
            Quicksort(arr, l, j);
            Quicksort(arr, j+1, r);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        arr[n] = Integer.MAX_VALUE;
        Quicksort(arr,0,n);
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
    }
}
