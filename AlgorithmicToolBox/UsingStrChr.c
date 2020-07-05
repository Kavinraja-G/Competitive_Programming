#include<stdio.h>
#include<string.h>

int main()
{
    char s[] = "Welcome";
    char *p;
    int count = 0;
    p = strchr(s,'e');
    if(p!=NULL) count++;
    while (p!=NULL)
    {
        p = strchr(s+(p-s+1), 'e');
        if(p!=NULL)count++;
    }
    printf("%d",count);
}