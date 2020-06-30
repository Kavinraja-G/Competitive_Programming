#include<stdio.h>
#include<stdlib.h>
#define L long long

L int findMax(L int arr[], L int size)
{
    L int firstMax = -1, secondMax = -1;
    L int firstMaxIndex;
    for(int i=0;i<size;i++)
    {
        if(arr[i]>firstMax)
        {
            firstMax = arr[i];
            firstMaxIndex = i;
        }
    }
    for(int i=0;i<size;i++)
    {
        if(i!=firstMaxIndex  && arr[i]>secondMax)
        {
            secondMax = arr[i];
        }
    }
    return (firstMax*secondMax);
}

int main()
{
    L int size;
    scanf("%lld",&size);
    L int arr[size];
    for(int i=0;i<size;i++)
        scanf("%lld",&arr[i]);
    L int result = findMax(arr, size);
    printf("%lld",result);
}