/* Following is the problem statement.
You are given n activities with their start and finish times. Select the maximum number of activities 
that can be performed by a single person, assuming that a person can only work on a single activity at a time. */
#include<stdio.h>
#include<stdlib.h>

void sort(int start[], int finish[], int n)
{
    for(int i=1;i<n;i++)
    {
        int key = finish[i];
        int pair = start[i];
        int j = i-1;
        while (j>=0 && key<finish[j])
        {
            finish[j+1] = finish[j];
            start[j+1] = start[j];
            j-=1;
        }
        finish[j+1] = key;
        start[j+1] = pair;
    }
}

void activitySearch(int start[], int finish[], int n)
{
    int curr=0,next = 1;
    printf("S:%d F:%d\n",start[curr],finish[curr]);
    while (next<n)  
    {
        if(finish[curr]<=start[next])
        {
            printf("S:%d F:%d\n",start[next],finish[next]);
            curr = next;
        }
        next++;
    }
}

int main()
{
    //Size of the both arrays
    int n;
    scanf("%d",&n);
    int start[n],finish[n];
    for(int i=0;i<n;i++)
    {
        scanf("%d %d",&start[i],&finish[i]);
    }
    sort(start,finish,n);
    for(int i=0;i<n;i++)
    {
        printf("S: %d | F: %d\n",start[i],finish[i]);
    }
    activitySearch(start,finish,n);
}