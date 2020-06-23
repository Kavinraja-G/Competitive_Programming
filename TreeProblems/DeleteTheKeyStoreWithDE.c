#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

struct node
{
    int data;
    struct node *left;
    struct node *right;
}*root= NULL;

struct queue
{
    int size;
    int front;
    int rear;
    struct node **Q;
}*q=NULL;

void createQueue(int size)
{
    q->size = size;
    q->front = -1;
    q->rear = -1;
    q->Q = (struct node **)malloc(q->size * sizeof(struct node*));
}

void enqueue(struct node *t)
{
    q->rear = (q->rear + 1)%q->size;
    q->Q[q->rear] = t;
}

void dequeue()
{
    q->front = (q->front+1)%q->size;
    q->Q[q->front];
}

int isEmpty()
{
    return (q->front == q->rear);
}

struct node * peek()
{
    struct node *t = NULL;
    t = q->Q[q->rear];
    return t;
}

void inOrder(struct node *t)
{
    if(t)
    {
        inOrder(t->left);
        printf("%d |",t->data);
        inOrder(t->right);
    }
}

void deleteNode(struct node *root, struct node *toDelete)
{
    struct queue *q = NULL;
    q = (struct queue *)malloc(sizeof(struct queue));
    createQueue(20);
    enqueue(root);

    struct node *temp;
    while (!isEmpty())
    {
        temp = peek();
        dequeue();

        if(temp == toDelete)
        {
            temp = NULL;
            return;
        }
        if(temp->left)
        {
            if(temp->left == toDelete)
            {
                temp->left = NULL;
                return;
            }
            else
                enqueue(temp->left);
        }
        if(temp->right)
        {
            if(temp->right == toDelete)
            {
                temp->right = NULL;
                return;
            }
            else
                enqueue(temp->right);
        }
    }
}

struct node * deleteKey(struct node *root, int data)
{
    if(!root)
        return NULL;
    q = (struct queue *)malloc(sizeof(struct queue));
    createQueue(10);
    enqueue(root);

    struct node *t=NULL;
    struct node *keyNode = NULL;
    while (!isEmpty())  
    {
        t = peek();
        dequeue();
        if(t->data == data)
            keyNode = t;
        if(t->left)
            enqueue(t->left);
        if(t->right)    
            enqueue(t->right);
    }

    if(keyNode!=NULL)
    {
        int deepestNodeData = t->data;
        deleteNode(root, t);
        keyNode->data = deepestNodeData;
    }
    return root;
}

struct node *newNode(int data)
{
    struct node *n = NULL;
    n = (struct node *)malloc(sizeof(struct node));
    n->data = data;
    n->left = NULL; n->right = NULL;
    return n;
};

int main()
{
    root = newNode(10); 
    root->left = newNode(11); 
    root->left->left = newNode(7); 
    root->left->right = newNode(12); 
    root->right = newNode(9); 
    root->right->left = newNode(15); 
    root->right->right = newNode(8);    
    inOrder(root);
    deleteKey(root,10);
    printf("\n");
    inOrder(root);
}