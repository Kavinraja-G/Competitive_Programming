#include<stdio.h>
#include<stdlib.h>

//The below method can be optimised by using the sorted array and checking till element which
//is less than or equal to the target sum. So that the recursive nodes and calls can be reduced

void printSubset(int res[], int resSize)
{
    for(int i=0;i<resSize;i++)
        printf("%d ", res[i]);
    printf("\n");
}

void sumOfSubsets(int arr[], int res[], int arrSize, int resSize, int currSum, int depth, int const targetSum)
{
    if(targetSum == currSum)
    {
        printSubset(res,resSize);
        //Now remove the last element and move the depth to the next node
        sumOfSubsets(arr, res, arrSize, resSize-1, currSum-arr[depth], depth+1, targetSum);
        return;
    }
    else
    {
        for(int i=depth; i<arrSize; i++)
        {
            res[resSize] = arr[i];
            //Now, increase the depth+1, currentSum += arr[i], also subset size+1
            sumOfSubsets(arr, res, arrSize, resSize+1, currSum+arr[i], i+1, targetSum);
        }
    }
}

void generateSubsets(int arr[], int size, int sum)
{
    int *result = (int *)malloc(size * sizeof(int));
    //First argument is for increasing the index of result
    //Second is for current sum
    //Third is for increasing the depth of the recursion
    sumOfSubsets(arr,result,size,0,0,0,sum);
}

int main()
{
    int size,sum=0;
    scanf("%d",&size);
    int arr[size];
    for(int i=0;i<size;i++)
        scanf("%d",&arr[i]);
    scanf("%d",&sum);
    generateSubsets(arr,size,sum);
}