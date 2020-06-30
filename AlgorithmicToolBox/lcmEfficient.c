#include<stdio.h>
#include<stdlib.h>
/*
    Approach 1: To find the GCD by the formula (GCD * LCM) = Prod of given two numbers
    Approach 2: -> Find the largest no of given.
                -> Increment it with itself until the small no perfectly divides it
                -> Then, larger no will be the answwer
*/
long long int gcd(long long int a, long long int b)
{
    if(b == 0)
        return a;
    return gcd(b, (a%b));
} 

long long int lcm(long long int a, long long int b)
{
    long long int gcdV = gcd(a,b);
    return ((a*b)/gcdV);
}

int main()
{
    long long int a, b;
    scanf("%lld %lld",&a,&b);
    printf("%lld",lcm(a,b)); 
}