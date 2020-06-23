#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int isSquare(int n)
{
    int x = sqrt(n);
    return (x*x == n);
}

int checkFibonacci(int n)
{
    return isSquare(5*n*n +4) || isSquare(5*n*n -4);
}

int main()
{
    int n;
    scanf("%d",&n);
    printf(checkFibonacci(n) ? "Yes" : "No");
}