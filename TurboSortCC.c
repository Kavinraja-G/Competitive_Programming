#include<stdio.h>
#include<stdlib.h>

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int a[], int l,int h)
{
    int pivot = a[h];
    int i=l-1;
    for(int j=i;j<=h-1;j++)
    {
        if(a[j]<pivot)
        {
            i++;
            swap(&a[i],&a[j]);
        }
        swap(&a[i+1],&a[h]);
        return i+1;
    }
}

void QuickSort(int a[], int l, int h)
{
    int j;
    if(l<h)
    {
        j = partition(a,l,h);
        QuickSort(a,l,j-1);
        QuickSort(a,j+1,h);
    }
}

int main()
{
    int size;
    scanf("%d",&size);
    int a[size];
    for(int i=0;i<size;i++)
        scanf("%d",&a[i]);
    QuickSort(a,0,size-1);
    for(int i=0;i<size;i++)
        printf("%d\n",a[i]);
}