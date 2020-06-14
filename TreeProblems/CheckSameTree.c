#include<stdio.h>
#include<malloc.h>

/*
    Program to check whether the two given trees are same or not
*/

struct node 
{
    int val;
    struct node *left;
    struct node *right;
};

int checkSame(struct node* p, struct node* q)
{
        if(p==NULL&&q==NULL)return 1;
        if(p==NULL&&q!=NULL)return 0;
        if(p!=NULL&&q==NULL)return 0;
        if(p->val!=q->val)return 0;
    int res1 = checkSame(p->left,q->left);
    int res2 = checkSame(p->right,q->right);
    return res1 && res2;
}

int main()
{
    
}