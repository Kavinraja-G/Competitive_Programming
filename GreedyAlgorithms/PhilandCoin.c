#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
int getMinimumDistribution(int price)
{
    int setCoins[price],dpValues[price+1];
    for(int i=0;i<price;i++)
        setCoins[i] = i+1;
    int coinsCount=0,currenSum=0;
    dpValues[0] = 0;
    for(int i=1;i<=price;i++)
        dpValues[i] = INT_MAX;
    for(int i=1;i<=price;i++)
    {
        for(int j=0;j<price;j++)
        {
            if(setCoins[j] <= i)
            {
                int x = dpValues[i-setCoins[j]];
                if(x != INT_MAX && x+1 < dpValues[i])
                    dpValues[i] = x+1;
            }
        }
    }
    return dpValues[price];
}

int main()
{
    int test;
    scanf("%d",&test);
    while (test-- >0)
    {
        int max_price;
        scanf("%d",&max_price);
        printf("%d\n",getMinimumDistribution(max_price));
    }
}