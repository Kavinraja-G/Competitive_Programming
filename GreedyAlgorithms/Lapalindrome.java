package DSA_CodeChef;

import java.util.Arrays;
import java.util.Scanner;
public class Lapalindrome {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        s.nextLine();
        while(test-- >0)
        {
            String ip = s.nextLine();
            if(isLaPalindrome(ip))
                System.out.println("YES");
            else
                System.out.println("NO");   
        }
        s.close();
    }
    static Boolean isLaPalindrome(String str)
    {
        StringBuilder ip = new StringBuilder(str);
        String sub1 = "";
        String sub2 = "";
        if(str.length()%2==0)
        {
            sub1 = ip.substring(0, (str.length()/2));
            sub2 = ip.substring(str.length()/2,str.length());
        }
        else
        {
            sub1 = ip.substring(0, (str.length()/2));
            sub2 = ip.substring((str.length()/2)+1,str.length());
        }
        char[] left = sub1.toCharArray();
        char[] right = sub2.toCharArray();
        Arrays.sort(left);
        Arrays.sort(right);
        sub1 = new String(left);
        sub2 = new String(right);
        return sub1.equals(sub2);     
    }
}