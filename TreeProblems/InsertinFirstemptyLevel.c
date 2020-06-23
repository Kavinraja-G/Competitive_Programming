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

void insertThroughEmpytLevel(struct node *root, int data)
{
    q = (struct queue *)malloc(sizeof(struct queue));
    createQueue(10);
    enqueue(root);
    struct node *n = (struct node *)malloc(sizeof(struct node));
    n->data = data;
    n->left = NULL; n->right = NULL;
    while (!isEmpty())
    {
        //Create a temp node with the front queue data and check its left and right
        struct node *temp = peek();
        dequeue();

        if(!temp->left)
        {
            temp->left = n;
            break;
        }else
            enqueue(temp->left);

        if(!temp->right)
        {
            temp->right = n;
            break;
        }else
            enqueue(temp->right);
    }
}
struct node * insert(struct node *root, int data)
{
    if(root == NULL)
    {
        struct node *n = (struct node*)malloc(sizeof(struct node));
        n->data = data;
        n->left = NULL;
        n->right = NULL;
        return n;
    }else
    {
        struct node *c;
        if(data<=root->data)
        {
            c = insert(root->left, data);
            root->left = c;
        }else
        {
            c = insert(root->right, data);
            root->right = c;
        }
    }
    return root;
}
int main()
{
    root = insert(root,10);
    root = insert(root,11);
    root = insert(root,7);
    root = insert(root,9);
    root = insert(root,15);
    root = insert(root,8);
    insertThroughEmpytLevel(root, 12);
    inOrder(root);
}