package DSA_CodeChef;

import java.util.*;

public class ReverseTheNumber
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test-- >0)
        {
            int num = s.nextInt();
            System.out.println(findReverse(num));
        }
        s.close();
    }
    static int findReverse(int copy) {
        int reversed = 0;
        while(copy > 0)
        {
            reversed = (reversed*10) + (copy%10); 
            copy = copy/10;
        }
        return reversed;
    }
}