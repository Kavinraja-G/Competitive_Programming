#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<limits.h>
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

void inOrder(struct node *root)
{
    if(root)
    {
        inOrder(root->left);
        printf("%d ",root->data);
        inOrder(root->right);
    }
}

int sizeOfTree(struct node *root)
{
    if(root == NULL)
        return 0;
    //Size of the tree is calculated by recursive through the left and right subtree
    return sizeOfTree(root->left) + 1 + sizeOfTree(root->right);
}

int maxOfTree(struct node *root)
{
    if(root == NULL)
        return INT_MIN;
    
    //We need to find the max of the root, left and right
    int max = root->data;
    int leftMax = maxOfTree(root->left);
    int rightMax = maxOfTree(root->right);
    if(leftMax > max)
        max = leftMax;
    if(rightMax > max)
        max = rightMax;
    return max;
}


int minOfTree(struct node *root)
{
    if(root == NULL)
        return INT_MAX;
    
    //We need to find the max of the root, left and right
    int min = root->data;
    int leftMin = minOfTree(root->left);
    int rightMin = minOfTree(root->right);
    if(leftMin < min)
        min = leftMin;
    if(rightMin < min)
        min = rightMin;
    return min;
}

void printLeftView(struct node *root, int level, int *maxLevel)
{
    if(!root)
        return;
    
    if(*maxLevel < level)
    {
        printf("%d ",root->data);
        *maxLevel = level;
    }
    printLeftView(root->left, level+1, maxLevel);
    printLeftView(root->right, level+1, maxLevel);
}

void leftViewHelper(struct node *root)
{
    int maxLevel = 0;
    printLeftView(root, 1, &maxLevel);
}

int main()
{
    struct node *root = newNode(1);
    root->left        = newNode(2); 
    root->right       = newNode(3); 
    root->left->left  = newNode(4); 
    root->left->right = newNode(5);  
    printf("LevelOrder Tree: ");
    inOrder(root);
    printf("\nSize: %d",sizeOfTree(root));
    printf("\nMax: %d",maxOfTree(root));
    printf("\nMin: %d",minOfTree(root));
    printf("\nLeft View: ");
    leftViewHelper(root);         
}