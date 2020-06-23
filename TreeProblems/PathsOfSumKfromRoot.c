#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<limits.h>
static int index = 0;
struct node 
{
    int data;
    struct node *left;
    struct node *right;
};

struct node * newNode(int data)
{
    struct node *t = NULL;
    t = (struct node *)malloc(sizeof(struct node));
    t->data = data;
    t->left = t->right = NULL;
    return t;
}

void printPathSum(int path[], int i)
{
    for(int x=0;x<=i;x++)
    {
        printf("%d ",path[x]);
    }
    printf("\n");
}

void printPathUtil(struct node *root,int sum, int path[])
{
    if(!root)
        return;
    
    path[index++] = root->data;
    printPathUtil(root->left, sum, path);
    printPathUtil(root->right, sum, path);
    int currSum = 0;
    for(int i=0;i<=index;i++)
    {
        currSum += path[i];
        if(currSum == sum)
            printThePath(path,i);
        //Here we need remove the current element to see with the other choices
        path[i] = 0;
        index--;
    }
}

void printPathFromRoot(struct node *root, int sum)
{
    //Path array should be replaced with the ArrayList or Vector
    int path[5] ={0};
    printPathUtil(root, sum, &path);
}

int main()
{
    struct node *root = newNode(1);
    root->left        = newNode(3); 
    root->left->left  = newNode(2);
    root->left->right = newNode(1);  
    root->left->right->left = newNode(1);  
    root->right       = newNode(-1); 
    root->right->left  = newNode(4); 
    root->right->left->left  = newNode(1);
    root->right->left->right  = newNode(2); 
    root->right->right = newNode(5);  
    root->right->right->right = newNode(2);  
    int sum = 5;
    printPathFromRoot(root, sum);
}