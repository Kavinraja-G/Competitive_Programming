#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

struct node 
{
    int data;
    struct node *left;
    struct node *right;
};

struct queue
{
    int front;
    int rear;
    struct node **Q;
}*q=NULL;

void createQueue()
{
    q = (struct queue *)malloc(sizeof(struct queue));
    q->front = -1;
    q->rear = -1;
    q->Q = (struct node **)malloc(100 * sizeof(struct node *));
}

void enqueue(struct node *data)
{
    q->rear+=1;
    q->Q[q->rear] = data;
}

void dequeue()
{
    q->front+=1;
    q->Q[q->front] = NULL;
}

struct node * front()
{
    struct node *data=NULL;
    data = (struct node *)malloc(sizeof(struct node));
    data->left = NULL; data->right = NULL;
    data = q->Q[q->front+1];
    return data;
}

int isEmpty()
{
    return q->front == q->rear;
}

struct node * insert(struct node *root, int data)
{
    struct node *new=NULL;
    new = (struct node *)malloc(sizeof(struct node));
    new->data = data;
    new->left = NULL;
    new->right = NULL;    
    
    if(root == NULL)
    {
        root = new;
    }
    else if(front()->left == NULL)
    {
        front()->left = new;
    }
    else
    {
        front()->right = new;
        dequeue();
    }
    enqueue(new);
    return root;
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
int main()
{
    struct node *root=NULL;
    createQueue();
    int size,data;
    scanf("%d",&size);
    int input[size];
    for(int i=0;i<size;i++)
    {    
        scanf("%d",&input[i]);
    }
    for(int i=0;i<size;i++)
    {
        root = insert(root,input[i]);
    }
    inOrder(root);
}