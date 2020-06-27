#include<stdio.h>
#include<stdlib.h>

int countWays(int values[], int size, int amount)
{
    //If amount is 0 no coins are included
    if(amount == 0)
        return 1;
    
    //If the amount is less than 0 (No solution)
    if(amount < 0)
        return 0;

    //if coins are 0 and amount > 0 (No solution)
    if(size<=0 && amount>0)
        return 0;
    
    //Two sub problems are possible 
    //1. By including the mth coin (We should reduce the amount to indicate we have included in the solution)
    //2.Excluding it from the amount (Simply remove it from the array by reducing the size)
    return countWays(values, size-1, amount) + countWays(values, size, amount-values[size-1]);
}

int main()
{
    int values[] = {1,2,3};
    int size = sizeof(values)/sizeof(values[0]);
    int count = countWays(values, size, 4);
    printf("%d",count);
}