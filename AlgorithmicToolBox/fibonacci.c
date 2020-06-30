#include<stdio.h>
#include<stdlib.h>

long long int fibonacci(long long int n)
{
    long long int a[n+1];
    a[0] = 0;
    a[1] = 1;
    for(int i=2;i<=n;i++)
        a[i] = a[i-2]+a[i-1];
    return a[n];
}

int main()
{
    long long int n;
    scanf("%lld",&n);
    printf("%lld", fibonacci(n));
}