import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    static int binarySearch(int[] arr,int l, int r, int search)
    {
        if(l<=r)
        {
            int mid = l + (r-l)/2;
            if(arr[mid] == search)
                return mid;
            if(search<arr[mid])
                return binarySearch(arr, l,mid-1, search);
            return binarySearch(arr, mid+1, r, search);
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        Arrays.sort(arr);
        int search = s.nextInt();
        System.out.println(binarySearch(arr, 0, n-1, search));
    }
}
