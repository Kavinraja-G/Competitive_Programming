#include<stdio.h>
#include<string.h>
#include<malloc.h>

void swapChars(char *a,char *b)
{
    char temp = *b;
    *b = *a;
    *a = temp;
}

void permutate(char *str, int start, int end)
{
    if(start == end) //Base case for the recursion to terminate and return the permuted string
    {
        printf("%s\n",str);
    }
    else
    {
        for(int i=start;i<=end;i++)
        {
            swapChars((str+start),(str+i)); //Swapping the characters in each stage
            permutate(str,start+1,end);     //For itterating throughout the all char's
            swapChars((str+start),(str+i)); //For restoring back to the previous stage
        }
    }
}

int main()
{
    char *str;
    str = (char *)malloc(10 * sizeof(char));
    scanf("%s",str);
    int len = strlen(str);
    permutate(str,0,len-1);
}