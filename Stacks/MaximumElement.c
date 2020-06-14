#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<string.h>
long long int s[100000];
long long int z = -1;
void emptyStack()
{
    while (z== -1)  
    {
        z--;
    }
}
int isEmpty()
{
    return(z == -1);
}
void push(long long int data)
{
    s[++z] = data;
}
void pop()
{
    z--;
}
long long int peek()
{
    return s[z];
}

int main()
{
    int op;
    long int n;
    scanf("%ld",&n);
    while (n-- >0)
    {
        scanf("%d",&op);
        switch (op)
        {
            case 1:
            {            
                long long int x;
                scanf("%lld",&x);
                if(z==-1) push(x);
                else
                {
                    s[z+1] = (x>peek())?x:peek();
                    z++;
                }
                break;
            }
            case 2:
            {
                pop();
                break;
            }
            case 3:
            {
                printf("%lld\n",s[z]);
                break;
            }
        default:
            exit(0);
        }
    }
}