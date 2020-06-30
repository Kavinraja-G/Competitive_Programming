#include<stdio.h>
#include<stdlib.h>

int fibonacci(long long int n)
{  
    int prev, curr;
    prev = 0;
    curr = 1;
    for(int i=2;i<=n;i++)
    {
        int temp = curr;
        curr = (prev + curr)%10;   //Here we store only the last digit of a fibonacci number
        prev = temp; 
    }
    return curr;
}

int main()
{
    long long int n;
    scanf("%lld",&n);
    printf("%d", fibonacci(n));
}