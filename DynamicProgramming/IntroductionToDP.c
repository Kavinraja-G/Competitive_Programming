/*
DYNAMIC PROGRAMMING:
        It is nothing but storing the answers of the subproblems invoolved in the problem that we are solving 
        and so that we can able to reuse the solution of those in the latter part of the problem if we need. 
        For example: Finding the nth fibonacci of a number may involve several overlapping subproblems those
        answers can be stored dynamically in an array and later reused for other subproblem calculations.
        Storing these answers can be done in two methods:
        1) Memoization: Usually called as the Top-Down approach
        2) Tabulation: It is called as the bottom up approach
*/

//Finding the nth Fibonacci series number using Memoization:

#include<stdio.h>
#include<stdlib.h>

#define SIZE 100
int result[SIZE]; 

//Here we initialize the result array with all values -1
void intializeResult()
{
    for(int i=0;i<SIZE;i++)
        result[i] = -1;
}

int Memoization(int pos)
{
    if(result[pos] == -1)
    {
        if(pos<=1)
            result[pos] = pos;
        else
            result[pos] = Memoization(pos-1) + Memoization(pos-2);
    }
    return result[pos];
}

//Finding the nth Fibonacci series number using Tabulation Method (BOTTOM-UP):

int bottomUp(int pos)
{
    int store[pos+1];
    store[0] = 0;
    store[1] = 1;
    for(int i=2;i<=pos;i++)
        store[i] = store[i-1] + store[i-2];
    return store[pos];
}

int main()
{
    int val;
    printf("Enter the nth position to find Fibonacci number:\n");
    scanf("%d",&val);
    intializeResult();
    printf("%d \n",Memoization(val));
    printf("%d \n",bottomUp(val));
}