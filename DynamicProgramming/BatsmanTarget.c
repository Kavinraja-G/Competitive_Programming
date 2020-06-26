#include<stdio.h>
#include<stdlib.h>

// int findWays(int target, int size, int score[])
// {
//     if(target == 0)
//         return 1;
//     if(target < 0)
//         return 0;
//     if(size<=0 && target>0)
//         return 0;
//     return findWays(target, size-1, score) + findWays(target-score[size-1], size, score);
// }

int findWays(int target)
{
    int dp[target+1];
    memset(dp, 0, sizeof(dp));
    dp[0] = 1;
    for(int i=2;i<=target;i++)
        dp[i] += dp[i-2];
    for(int i=4;i<=target;i++)
        dp[i] += dp[i-4];
    for(int i=6;i<=target;i++)
        dp[i] += dp[i-6];
    return dp[target];
}
int main()
{
    int target;
    int score[] = {2,4,6};
    scanf("%d",&target);
    int count = findWays(target);
    printf("%d",count);
}