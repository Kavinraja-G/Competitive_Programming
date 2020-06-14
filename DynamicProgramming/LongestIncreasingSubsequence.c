#include<stdio.h>
#include<stdlib.h>

/*
STATEMENT:
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence 
such that all elements of the subsequence are sorted in increasing order.For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} 
is 6 and LIS is {10, 22, 33, 50, 60, 80}

ALGORITHM:
Let us consider the following example:
    Input  : arr[] = {3, 10, 2, 11}
    Length[] = {1, 1, 1, 1} (initially)
    Now, starting the outside loop from arr[1] and inside loop to run from arr[0] to arr[j<i] we need to check two conditions:
        1. If the element indexing at i is greater than that of the j element in arr.
        2. If the length in the current 'i' index is less than that of length pointing length[j]+1.
    If the above mentioned conditions satisfied than increase the current element of the length array by length[i] = length[j]+1
    Perform the above till the end of the array
    Finnaly, find the maximum element in the length array that gives us the maximum increasing subsequence.  

TIME COMPLEXITY: O(N^2)
SPACE COMPLEXITY: O(N)
Reference: GeeksForGeeks
*/

void findMaxLength(int arr[], int length[], int size)
{
    for(int i=1;i<size;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(arr[i]>arr[j] && length[i] < length[j]+1)
                length[i] = length[j]+1;
        }
    }
}

int main()
{
    int size;
    scanf("%d",&size);
    int arr[size],listofLength[size];

    //Initalizing the listofLength array to values '1'
    for(int i=0;i<size;i++)
    {    
        scanf("%d",&arr[i]);
        listofLength[i] = 1;
    }

    findMaxLength(arr, listofLength, size);

    //Now find the max_element in the listofLength Array
    int max = listofLength[0];
    for(int i=1;i<size;i++)
    {
        if(listofLength[i]>max)
            max = listofLength[i];
    }
    for(int i=0;i<size;i++)
        printf("%d ",listofLength[i]);
    printf("The maximum subsequent Length: %d",max);
}