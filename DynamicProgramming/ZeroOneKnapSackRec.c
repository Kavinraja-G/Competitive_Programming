#include<stdio.h>
#include<stdlib.h>

int max(int a, int b)
{
    return (a>b) ? a : b;
}

int knapSack(int capacity, int weight[], int values[], int size)
{
    if(size == 0 || capacity == 0)
        return 0;

    if(weight[size-1] > capacity)
        return knapSack(capacity, weight, values, size-1);

    else
        return max(
            values[size-1] + knapSack(capacity - weight[size-1], weight, values, size-1),
            knapSack(capacity, weight, values, size-1));
}

int main()
{
    int size;
    scanf("%d",&size);
    int values[size];
    int weight[size];
    for(int i=0;i<size;i++)
        scanf("%d",&weight[i]);
    for(int i=0;i<size;i++)
        scanf("%d",&values[i]);
    int capacity;
    scanf("%d",&capacity);
    printf("%d", knapSack(capacity, weight, values, size));
}