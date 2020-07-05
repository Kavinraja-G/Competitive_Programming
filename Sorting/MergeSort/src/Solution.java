package Sorting.MergeSort.src;

import java.util.Scanner;
public class Solution {
    static void merge(int[] arr, int l, int mid, int r)
    {
        int[] temp = new int[100];
        int i = l, j = mid+1, k = l;
        while (i<=mid && j<=r)
        {
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        for(;i<=mid;i++)
            temp[k++] = arr[i];
        for(;j<=r;j++)
            temp[k++] = arr[j];
        for(int index=l; index<=r; index++)
            arr[index] = temp[index];
    }

    static void mergeSort(int[] arr, int l, int r)
    {
        int mid;
        if(l<r)
        {
            mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        double start = System.currentTimeMillis();
        mergeSort(arr, 0, n-1);
        double stop = System.currentTimeMillis();
        double duration = stop-start;
        System.out.println(duration);
//        for(int el : arr)
//            System.out.print(el+" ");
    }
}
