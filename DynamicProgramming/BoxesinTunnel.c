#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

int main()
{
    int a = 9,b=9,c=20;
    a = ++b + ++c + a++;
    printf("%d",a);
}