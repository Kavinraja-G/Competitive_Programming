#include<stdio.h>
#include<stdlib.h>

int max(int a, int b)
{
    return (a>b)?a:b;
}

int knapSack(int capacity, int weight[], int values[], int n)
{
    //Dynamically storing all possible results in the array
    int dp[n+1][capacity+1];
    
    for(int size=0; size<=n; size++)
    {
        for(int cap=0; cap<=capacity; cap++)
        {
            //Filling all the base cases as in Recursion method
            if(size==0 || cap == 0)
                dp[size][cap] = 0;

            //Here when the current weight is less than the capacity we choose max of two conditions
            // 1. Include the nth value, add the nth value to dp array, reduce the size by one
            // 2. Exclude the nth value and reduce the size by one
            else if(weight[size-1] <= cap)
                dp[size][cap] = max(
                    values[size-1] + dp[size-1][cap-weight[size-1]],
                    dp[size-1][cap]);
            
            //Here we simply exclude the last value if it's weight is > than capacity (current capacity -> cap)
            else
                dp[size][cap] = dp[size-1][cap];
        }
    }
    return dp[n][capacity];
}

int main()
{
    int size;
    scanf("%d",&size);
    int values[size];
    int weight[size];
    for(int i=0;i<size;i++)
        scanf("%d",&values[i]);
    for(int i=0;i<size;i++)
        scanf("%d",&weight[i]);
    int capacity;
    scanf("%d",&capacity);
    printf("%d", knapSack(capacity, weight, values, size));
}