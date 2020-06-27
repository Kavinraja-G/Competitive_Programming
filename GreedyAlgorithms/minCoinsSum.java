package DSA_CodeChef;
import java.util.*;
public class minCoinsSum {
    static int findMin(int s, int size, ArrayList<Integer> coins)
    {
        int[] dp = new int[s+1];
        dp[0] = 0;
        for(int i=1;i<=s;i++)
            dp[i] = Integer.MAX_VALUE;
        for(int i=1;i<=s;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(coins.get(j) <= i)
                {
                    int curr = dp[i-coins.get(j)];
                    if(curr+1 < dp[i])
                        dp[i] = curr+1;
                }
            }
        }
        return dp[s];
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test-- >0)
        {
            int S = s.nextInt();
            int N = s.nextInt();
            ArrayList<Integer> coins = new ArrayList<>();
            coins.add(1);
            for(int i = 2; i<=N;i+=2)
                coins.add(i);
            int res = findMin(S, coins.size(), coins);
            System.out.println(res);
        }
        s.close();
    }
}